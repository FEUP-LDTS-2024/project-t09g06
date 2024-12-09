package ldts.t09g06.gui;

import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import ldts.t09g06.model.Position;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import ldts.t09g06.model.leaderboard.Player;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import static ldts.t09g06.model.Constants.*;

public class LanternaGUI implements GUI {
    private  Screen screen;
    AWTTerminalFontConfiguration fontConfiguration;
    private char currChar;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        fontConfiguration = loadFont();
        Terminal terminal = createTerminal(width, height,fontConfiguration);
        this.screen = createScreen(terminal);

        this.currChar = 'x';
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }


    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfiguration) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfiguration);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private AWTTerminalFontConfiguration loadFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 6);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public void resizeScreen(int width, int height) throws IOException {
        if (screen != null) screen.close();
        Terminal terminal = createTerminal(width,height,fontConfiguration);
        this.screen = createScreen(terminal);
    }

    public ACTION getNextAction() throws IOException {

        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;


        switch (keyStroke.getKeyType()) {
            case EOF:
                return ACTION.QUIT;
            case Character:
                setCurrChar(keyStroke.getCharacter());
                if(keyStroke.getCharacter() == 'q') {
                    return ACTION.QUIT;
                }
                if(keyStroke.getCharacter() == ' ') {
                    return ACTION.SHOOT;
                }
                else {
                    return ACTION.TYPE;
                }

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
            case Backspace:
                return ACTION.UNDO;
            default:
                break;
        }
        return ACTION.NONE;
    }

    @Override
    public void drawHero(Position position) {
        drawCharacter(position.getX(), position.getY(), 'H', WHITE);
    }

    @Override
    public void drawWall(Position position) {
        drawCharacter(position.getX(), position.getY(), '#', RED);
    }

    @Override
    public void drawMonster(Position position) {
        drawCharacter(position.getX(), position.getY(), 'M', GREEN);
    }

    @Override
    public void drawAmmo(Position position) {
        drawCharacter(position.getX(), position.getY(), 'o', LIGHTBLUE);
    }

    @Override
    public void drawLeaderboard(List<Player> players) {

        Position pos = new Position(2,5);

        drawText(pos,"Leaderboard",WHITE);
        pos.setY(pos.getY()+4);
        drawText(pos,"Pos  " + "Name" + "           Score", WHITE);

        pos.setY(pos.getY()+2);

        int playerRank = players.size();
        if (playerRank > 23){
            playerRank = 23;
        }
        for (int i = 0; i < playerRank; i++){
            Player player = players.get(i);
            String name;
            if (player.getName().length() <= maxNameLength) {
                name = player.getName();
            }
            else if (player.getName().isBlank()) {
                name = "Dummy";
            }
            else {
                name = player.getName().substring(0, maxNameLength-3) + "...";
            }
            pos.setY(pos.getY()+1);
            drawText(pos,String.valueOf(i+1) + "    " + name, WHITE);
            pos.setX(pos.getX()+20);
            drawText(pos,String.valueOf(player.getScore()), WHITE);
            pos.setX(pos.getX()-20);
        }

        List<String> options = Collections.singletonList("Back to Menu");

    }

    public void drawInsertName(String name, boolean invalidInput) {
        Position pos = new Position(3,5);

        drawText(pos, "You just lose the game!", WHITE);
        pos.setY(pos.getY()+1);
        drawText(pos, "Please insert your name (it must be less than 10 chars).", WHITE);

        pos.setY(pos.getY()+2);

        drawText(pos,name , GREEN);

        pos.setY(pos.getY()+3);
        if(invalidInput) {
            drawText(pos,"Must contain chars and smaller than 10!", RED);
        }

        pos.setY(pos.getY()+5);
        drawText(pos, "Press enter to submit", WHITE);

    }


    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    public void drawPixel(double x, double y, TextColor color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(color);
        tg.setCharacter((int) x, (int) y, ' ');
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
    @Override
    public Screen getScreen() {
        return screen;
    }

    public char getCurrChar() {
        return currChar;
    }

    public void setCurrChar(char currChar) {
        this.currChar = currChar;
    }
}