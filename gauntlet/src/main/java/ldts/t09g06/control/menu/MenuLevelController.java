package ldts.t09g06.control.menu;

import ldts.t09g06.Game;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Constants;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.arena.LoadArenaBuilder;
import ldts.t09g06.model.game.arena.Screen;
import ldts.t09g06.model.menu.GenericMenu;
import ldts.t09g06.model.menu.Menu;
import ldts.t09g06.control.Controller;
import ldts.t09g06.model.menu.MenuLevel;
import ldts.t09g06.states.GameState;

import java.io.IOException;


import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Constants;

import static ldts.t09g06.model.Constants.SCREEN_HEIGHT;
import static ldts.t09g06.model.Constants.SCREEN_WIDTH;

public class MenuLevelController extends Controller<MenuLevel> {
    public MenuLevelController (MenuLevel menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                Arena arena = new LoadArenaBuilder(getModel().getCurrentEntry()+1).createArena();
                Screen screen = new Screen(arena, SCREEN_WIDTH, SCREEN_HEIGHT);
                game.setState(new GameState(screen));
                game.getGui().resizeScreen(arena.getWidth(), arena.getHeight());
        }
    }
}
