package ldts.t09g06.control.leaderboard;

import ldts.t09g06.Game;
import ldts.t09g06.control.Controller;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Constants;
import ldts.t09g06.model.leaderboard.InsertName;
import ldts.t09g06.model.leaderboard.Player;
import ldts.t09g06.model.menu.Menu;
import ldts.t09g06.states.MenuState;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class InsertNameController extends Controller<InsertName> {

    public InsertNameController(InsertName model) {super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        char currChar;
        switch(action) {
            case TYPE:
                currChar = game.getGui().getCurrChar();
                getModel().setName(getModel().getName() + currChar);
                break;
            case A:
                currChar = 'a';
                getModel().setName(getModel().getName() + currChar);
                break;
            case D:
                currChar = 'd';
                getModel().setName(getModel().getName() + currChar);
                break;
            case S:
                currChar = 's';
                getModel().setName(getModel().getName() + currChar);
                break;
            case W:
                currChar = 'w';
                getModel().setName(getModel().getName() + currChar);
                break;
            case UNDO:
                eraseLastChar();
                break;
            case SELECT:
                if (getModel().getName().matches(".*[a-zA-Z].*")) {
                    Player player = new Player(
                            getModel().getName(),
                            getModel().getHero().getScore());
                    game.getLeaderboard().addPlayertoLeaderboard(player);
                    game.getGui().resizeScreen(Constants.menuWidth, Constants.menuHeight); //this should be included in each setState
                    game.setState(new MenuState(new Menu()));
                } else {
                    invalidInput();
                }
                break;
            case QUIT:
                game.getGui().resizeScreen(Constants.menuWidth, Constants.menuHeight); //this should be included in each setState
                game.setState(new MenuState(new Menu()));
                break;
        }
    }
    private void invalidInput() {
        getModel().setInvalidInput(true);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getModel().setInvalidInput(false);
            }
        }, 3000);
    }

    private void eraseLastChar() {
        String name = getModel().getName();
        if (!name.isEmpty()){
            getModel().setName(name.substring(0, name.length()-1));
        }
    }
}
