package ldts.t09g06.gui;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.game.elements.Element;
import ldts.t09g06.model.leaderboard.Player;

import java.io.IOException;
import java.util.List;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawHero(Position position);

    void drawWall(Position position);

    void drawMonster(Position position);

    void drawAmmo(Position position);

    void drawLeaderboard(List<Player> players);

    void drawInsertName(String name, boolean invalidInput);
    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    Screen getScreen();

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, SHOOT, UNDO, TYPE}
}
