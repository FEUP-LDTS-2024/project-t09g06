package ldts.t09g06.view;

import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.instructions.Instructions;

public class InstructionsViewer extends Viewer<Instructions> {
    public InstructionsViewer(Instructions model, ViewerManager viewerManager) {
        super(model);
    }
    @Override
    public void drawModel(GUI gui) {
        gui.drawInstructions(getModel().getInstructions());
    }
}
