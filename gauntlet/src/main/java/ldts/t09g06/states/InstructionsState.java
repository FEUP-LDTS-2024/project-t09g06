package ldts.t09g06.states;

import ldts.t09g06.control.Controller;
import ldts.t09g06.control.instructions.InstructionsController;
import ldts.t09g06.model.instructions.Instructions;
import ldts.t09g06.view.InstructionsViewer;
import ldts.t09g06.view.Viewer;

public class InstructionsState extends State<Instructions> {
    public InstructionsState(Instructions model) {
            super(model);
        }

        @Override
        protected Viewer<Instructions> getViewer() {
            return new InstructionsViewer(getModel());
        }

        @Override
        protected Controller<Instructions> getController() {
            return new InstructionsController(getModel());
        }
    }
