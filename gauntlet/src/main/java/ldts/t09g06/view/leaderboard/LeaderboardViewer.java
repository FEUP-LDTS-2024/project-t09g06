package ldts.t09g06.view.leaderboard;

import com.googlecode.lanterna.TerminalSize;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.leaderboard.Leaderboard;
import ldts.t09g06.model.leaderboard.Player;
import ldts.t09g06.view.Viewer;
import ldts.t09g06.view.ViewerManager;

import java.util.Collections;
import java.util.List;

import static ldts.t09g06.model.Constants.WHITE;
import static ldts.t09g06.model.Constants.maxNameLength;

public class LeaderboardViewer extends Viewer<Leaderboard> {
    public LeaderboardViewer(Leaderboard model, ViewerManager viewerManager) {
        super(model);
    }
    @Override
    public void drawModel(GUI gui) {
        List<Player> players = getModel().getPlayers();

        TerminalSize size = gui.getScreen().getTerminalSize();
        int screenWidth = size.getColumns();
        int screenHeight = size.getRows();
        int middleScreen = screenWidth / 2;

        int startY = 3;

        String title = "LEADERBOARD";
        gui.drawText(new Position(middleScreen - title.length() / 2, startY), title, "#0A3981");

        String headers = "POS      NAME      SCORE";
        gui.drawText(new Position(middleScreen - headers.length() / 2, startY + 2), headers, "#0A97B0");

        Position pos = new Position(middleScreen - headers.length() / 2, startY + 4);

        int playerRank = Math.min(players.size(), 23);

        for (int i = 0; i < playerRank; i++) {
            Player player = players.get(i);
            String name;

            if (player.getName().length() <= maxNameLength) {
                name = player.getName().toLowerCase();
            } else if (player.getName().isBlank()) {
                name = "dummy";
            } else {
                name = player.getName().substring(0, maxNameLength - 3).toLowerCase() + "...";
            }

            String row = String.format("%-8d%-12s%-6d", i + 1, name, player.getScore());

            gui.drawText(pos, row, WHITE);

            pos.setY(pos.getY() + 1);
        }

        List<String> options = Collections.singletonList("back to menu - press 'q'");
        gui.drawText(new Position(middleScreen - options.get(0).length() / 2, screenHeight - 4), options.get(0), WHITE);
    }
}
