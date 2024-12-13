package ldts.t09g06.control.menu;

import ldts.t09g06.Game;
import ldts.t09g06.control.Controller;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Constants;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.arena.LoadArenaBuilder;
import ldts.t09g06.model.menu.Menu;
import ldts.t09g06.model.menu.MenuLevel;
import ldts.t09g06.model.menu.MenuSettings;
import ldts.t09g06.states.GameState;
import ldts.t09g06.states.MenuState;

import java.io.IOException;

import static ldts.t09g06.model.Constants.VIEW_SIZE_X;
import static ldts.t09g06.model.Constants.VIEW_SIZE_Y;
public class MenuSettingsController extends Controller<MenuSettings> {
    public MenuSettingsController (MenuSettings menu) {
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
                game.getGui().setDifficulty(getModel().getCurrentEntry());
                getModel().setCurrent_difficulty(getModel().getCurrentEntry());
                getModel().updateEntries();
        }
    }
}
