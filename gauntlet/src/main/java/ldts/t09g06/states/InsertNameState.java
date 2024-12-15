package ldts.t09g06.states;

import ldts.t09g06.control.Controller;
import ldts.t09g06.control.leaderboard.InsertNameController;
import ldts.t09g06.model.leaderboard.InsertName;
import ldts.t09g06.view.SpriteLoader;
import ldts.t09g06.view.Viewer;
import ldts.t09g06.view.ViewerManager;
import ldts.t09g06.view.leaderboard.InsertNameViewer;

import java.io.IOException;

public class InsertNameState extends State<InsertName> {
    public InsertNameState(InsertName model, SpriteLoader spriteLoader) throws IOException {
        super(model,spriteLoader);
    }

    @Override
    protected Viewer<InsertName> getViewer(ViewerManager viewerManager) {
        return new InsertNameViewer(getModel(), viewerManager);
    }

    @Override
    protected Controller<InsertName> getController() {
        return new InsertNameController(getModel());
    }
}
