package ldts.t09g06.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import ldts.t09g06.model.Constants;
import ldts.t09g06.model.Position;

import java.awt.*;
import java.io.IOException;

public class LanternaGUI implements  GUI {

    private final Screen screen;

    private TextGraphics graphics;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException {

        //  Maybe make a loadFont function to be more dynamic
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 16);
        AWTTerminalFontConfiguration config = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, font);
        Terminal terminal = createTerminal(width, height, config);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen((terminal));
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen; // change this.screen right away or call createScreen Function every time ?
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration config) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height+1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(config);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    @Override
    public ACTION getNextAction() throws IOException {

        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;


        switch (keyStroke.getKeyType()) {
            case EOF:
                return ACTION.QUIT;
            case Character:
                if(keyStroke.getCharacter() == 'q') {
                    return ACTION.QUIT;
                }
            break;

            case ArrowRight:
                return ACTION.RIGHT;
            case ArrowLeft:
                return ACTION.LEFT;
            case ArrowUp:
                return ACTION.UP;
            case ArrowDown:
                return ACTION.DOWN;
            case Enter:
                return ACTION.SELECT;
            default:
                break;
        }



//
//        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
//        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;
//
//        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
//        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
//        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
//        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
//
//        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;
//
        return ACTION.NONE;
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.putString(position.getX(),position.getY(), text);
    }

    public void drawElement(int x, int y, char c, String color) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.putString(x, y+1,"" + c);
    }

    @Override
    public void drawPlayer(Position position) {
        drawElement(position.getX(), position.getY(), 'P', Constants.LIGHTBLUE);
    }

    @Override
    public void drawWall(Position position) {
        drawElement(position.getX(), position.getY(), '#', Constants.WHITE);
    }

    @Override
    public void drawSeparator(Position position) {
        drawElement(position.getX(), position.getY(), '*', Constants.WHITE);
    }


    @Override
    public void clear() {
        screen.clear();

    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    public Screen getScreen() {
        return this.screen;
    }
}
