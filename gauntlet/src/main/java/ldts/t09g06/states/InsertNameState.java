package ldts.t09g06.states;

import ldts.t09g06.control.Controller;
import ldts.t09g06.control.leaderboard.InsertNameController;
import ldts.t09g06.model.leaderboard.InsertName;
import ldts.t09g06.view.Viewer;
import ldts.t09g06.view.leaderboard.InsertNameViewer;

public class InsertNameState extends State<InsertName> {
    public InsertNameState(InsertName model) {
        super(model);
    }

    @Override
    protected Viewer<InsertName> getViewer() {
        return new InsertNameViewer(getModel());
    }

    @Override
    protected Controller<InsertName> getController() {
        return new InsertNameController(getModel());
    }
}
