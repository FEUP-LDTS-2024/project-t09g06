package ldts.t09g06.view;

import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.instructions.Instructions;

import java.util.List;

import static ldts.t09g06.model.Constants.WHITE;

public class InstructionsViewer extends Viewer<Instructions> {
    public InstructionsViewer(Instructions model, ViewerManager viewerManager) {
        super(model);
    }
    @Override
    public void drawModel(GUI gui) {
        List<String> instructions = getModel().getInstructions();
        Position position = new Position(2, 2);
        for (String line : instructions) {
            gui.drawText(position, line, WHITE);
            position.setY(position.getY() + 1);
        }
    }
}
