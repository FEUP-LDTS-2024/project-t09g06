package ldts.t09g06;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import ldts.t09g06.gui.LanternaGUI;

import java.io.IOException;
public class Application {
    public static void main(String[] args) throws IOException {
        LanternaGUI gui = new LanternaGUI();
        Game game = new Game();
        game.run();
    }
}
