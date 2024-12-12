package ldts.t09g06.states;

import ldts.t09g06.control.Controller;
import ldts.t09g06.control.instructions.InstructionsController;
import ldts.t09g06.model.instructions.Instructions;
import ldts.t09g06.view.InstructionsViewer;
import ldts.t09g06.view.SpriteLoader;
import ldts.t09g06.view.Viewer;
import ldts.t09g06.view.ViewerManager;

import java.io.IOException;

public class InstructionsState extends State<Instructions> {
    public InstructionsState(Instructions model, SpriteLoader spriteLoader) throws IOException {
            super(model,spriteLoader);
        }

        @Override
        protected Viewer<Instructions> getViewer(ViewerManager viewerManager) {
            return new InstructionsViewer(getModel(), viewerManager);
        }

        @Override
        protected Controller<Instructions> getController() {
            return new InstructionsController(getModel());
        }
    }
