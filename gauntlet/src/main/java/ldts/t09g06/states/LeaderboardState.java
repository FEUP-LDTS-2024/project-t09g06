package ldts.t09g06.states;

import ldts.t09g06.control.Controller;
import ldts.t09g06.control.leaderboard.LeaderboardController;
import ldts.t09g06.model.leaderboard.Leaderboard;
import ldts.t09g06.view.SpriteLoader;
import ldts.t09g06.view.Viewer;
import ldts.t09g06.view.ViewerManager;
import ldts.t09g06.view.leaderboard.LeaderboardViewer;

import java.io.IOException;

public class LeaderboardState extends State<Leaderboard> {
    public LeaderboardState(Leaderboard model, SpriteLoader spriteLoader) throws IOException {
        super(model,spriteLoader);;
    }

    @Override
    protected Viewer<Leaderboard> getViewer(ViewerManager viewerManager) {
        return new LeaderboardViewer(getModel(), viewerManager);
    }


    @Override
    protected Controller<Leaderboard> getController() {
        return new LeaderboardController(getModel());
    }
}
