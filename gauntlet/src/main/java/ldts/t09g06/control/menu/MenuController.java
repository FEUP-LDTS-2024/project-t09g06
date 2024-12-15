package ldts.t09g06.control.menu;

import ldts.t09g06.Game;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Constants;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.arena.LoadArenaBuilder;
import ldts.t09g06.model.menu.Menu;
import ldts.t09g06.control.Controller;
import ldts.t09g06.model.menu.MenuLevel;
import ldts.t09g06.model.menu.MenuSettings;
import ldts.t09g06.states.*;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
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
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()){
                    game.setState(new MenuLevelState(new MenuLevel(), game.getSpriteLoader()));
                }
                if(getModel().isSelectedInstructions()){
                    game.setState(new InstructionsState(game.getInstructions(), game.getSpriteLoader()));
                }
                if(getModel().isSelectedSettings()){
                    game.setState(new MenuSettingsState(new MenuSettings(game.getGui().getDifficultyLevel()), game.getSpriteLoader()));
                }
                if(getModel().isSelectedLeaderboard()) {
                    game.setState(new LeaderboardState(game.getLeaderboard(), game.getSpriteLoader()));
                }
        }
    }
}