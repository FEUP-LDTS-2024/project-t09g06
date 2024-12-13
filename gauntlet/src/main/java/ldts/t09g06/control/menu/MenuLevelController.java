package ldts.t09g06.control.menu;

import ldts.t09g06.Game;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Constants;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.arena.LoadArenaBuilder;
import ldts.t09g06.model.menu.GenericMenu;
import ldts.t09g06.model.menu.Menu;
import ldts.t09g06.control.Controller;
import ldts.t09g06.model.menu.MenuLevel;
import ldts.t09g06.states.GameState;

import java.io.IOException;


import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Constants;
import ldts.t09g06.states.MenuState;

import static ldts.t09g06.model.Constants.*;

public class MenuLevelController extends Controller<MenuLevel> {
    public MenuLevelController (MenuLevel menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case QUIT:
                game.getGui().resizeScreen(Constants.menuWidth, Constants.menuHeight);
                game.setState(new MenuState(new Menu(), game.getSpriteLoader()));
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                Arena arena = new LoadArenaBuilder(getModel().getCurrentEntry()+1, game.getGui().getDifficulty()).createArena();
                setDimensions(getModel().getCurrentEntry());
                game.setState(new GameState(arena, game.getSpriteLoader()));
                game.getGui().resizeScreen(VIEW_SIZE_X, VIEW_SIZE_Y);
                game.getGui().setTranslation(arena.getHero().getPosition());
        }
    }
}
