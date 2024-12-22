package ldts.t09g06.view.leaderboard;

import com.googlecode.lanterna.TerminalSize;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Constants;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.leaderboard.InsertName;
import ldts.t09g06.view.Viewer;
import ldts.t09g06.view.ViewerManager;

import static ldts.t09g06.model.Constants.*;

public class InsertNameViewer extends Viewer<InsertName> {
    public InsertNameViewer(InsertName model, ViewerManager viewerManager) {
        super(model);
    }

    @Override
    public void drawModel(GUI gui) {
        boolean invalidInput = getModel().isValidInput();
        String name = getModel().getName();
        TerminalSize size = gui.getScreen().getTerminalSize();
        int height = size.getRows();
        int width = size.getColumns();
        int middleScreen = width / 2;
        int middleHeight = height/2;
        int textStart = middleScreen - Constants.MENU.length() / 2;
        gui.drawText(new Position(textStart-15,middleHeight), "---------- GAME OVER ----------", COLOR_MENU);
        gui.drawText(new Position(3,middleHeight + 3), "Please insert your name (it must be less than 10 chars):", RED_ );
        gui.drawText(new Position(0,middleHeight +5), name , WHITE);

        if(invalidInput) {
            gui.drawText(new Position(0, middleHeight+4),"Must contain chars and smaller than 10!", RED);
        }

        gui.drawText(new Position(textStart,height-2), "Press enter to submit", WHITE);
    }
}
