package ldts.t09g06;

import ldts.t09g06.gui.LanternaGUI;
import ldts.t09g06.model.Constants;
import ldts.t09g06.model.instructions.Instructions;
import ldts.t09g06.model.leaderboard.Leaderboard;
import ldts.t09g06.model.menu.Menu;
import ldts.t09g06.states.MenuState;
import ldts.t09g06.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private final Leaderboard leaderboard;
    private final Instructions instructions;
    private State state;


    public Game() throws FontFormatException, IOException, URISyntaxException {
        //this.gui = new LanternaGUI(100, 50);
        this.leaderboard = new Leaderboard(null, "src/main/resources/leaderboard/leaderboard.txt");
        this.gui = new LanternaGUI(Constants.menuWidth, Constants.menuHeight);
        this.state = new MenuState(new Menu());
        this.instructions = new Instructions("src/main/resources/instructions.txt");
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }

    public LanternaGUI getGui() {
        return this.gui;
    }

    public State getState(){
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException {
        int FPS = 30;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }

        gui.close();
    }

    public Leaderboard getLeaderboard() {
        return leaderboard;
    }
    public Instructions getInstructions(){ return instructions;}
}
