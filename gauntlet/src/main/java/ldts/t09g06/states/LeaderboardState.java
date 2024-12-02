package ldts.t09g06.states;

import ldts.t09g06.control.Controller;
import ldts.t09g06.control.leaderboard.LeaderboardController;
import ldts.t09g06.model.leaderboard.Leaderboard;
import ldts.t09g06.view.Viewer;
import ldts.t09g06.view.leaderboard.LeaderboardViewer;

public class LeaderboardState extends State<Leaderboard> {
    public LeaderboardState(Leaderboard model) {
        super(model);
    }

    @Override
    protected Viewer<Leaderboard> getViewer() {
        return new LeaderboardViewer(getModel());
    }

    @Override
    protected Controller<Leaderboard> getController() {
        return new LeaderboardController(getModel());
    }
}
