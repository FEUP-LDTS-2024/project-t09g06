package ldts.t09g06.view.leaderboard;

import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.leaderboard.InsertName;
import ldts.t09g06.view.Viewer;
import ldts.t09g06.view.ViewerManager;

public class InsertNameViewer extends Viewer<InsertName> {
    public InsertNameViewer(InsertName model, ViewerManager viewerManager) {
        super(model);
    }

    @Override
    public void drawModel(GUI gui) {
            gui.drawInsertName(getModel().getName(), getModel().isValidInput());
    }
}
