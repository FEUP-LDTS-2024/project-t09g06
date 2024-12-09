package ldts.t09g06.view.leaderboard;

import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.leaderboard.Leaderboard;
import ldts.t09g06.view.Viewer;

public class LeaderboardViewer extends Viewer<Leaderboard> {
    public LeaderboardViewer(Leaderboard model) {
        super(model);
    }
    @Override
    public void drawModel(GUI gui) {
        gui.drawLeaderboard(getModel().getPlayers());
    }
}
