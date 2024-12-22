package ldts.t09g06.control.leaderboard;

import ldts.t09g06.Game;
import ldts.t09g06.control.Controller;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Constants;
import ldts.t09g06.model.leaderboard.Leaderboard;
import ldts.t09g06.model.menu.Menu;
import ldts.t09g06.model.menu.MenuLevel;
import ldts.t09g06.states.MenuLevelState;
import ldts.t09g06.states.MenuState;

import java.io.IOException;
import java.util.Objects;

public class LeaderboardController extends Controller<Leaderboard> {
    public LeaderboardController(Leaderboard model) {
        super(model);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
            case DOWN:
                getModel().nextEntry();
            case QUIT:
                game.setState(new MenuState(new Menu(), game.getSpriteLoader()));
        }


    }
}
