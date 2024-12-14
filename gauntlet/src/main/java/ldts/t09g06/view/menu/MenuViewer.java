package ldts.t09g06.view.menu;

import com.googlecode.lanterna.TerminalSize;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Constants;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.menu.Menu;
import ldts.t09g06.view.Viewer;
import ldts.t09g06.model.Constants.*;
import ldts.t09g06.view.ViewerManager;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu, ViewerManager viewerManager) {
        super(menu);
    }

    @Override
    public void drawModel(GUI gui) {
        // Get dynamic terminal size
        TerminalSize size = gui.getScreen().getTerminalSize();
        int terminalWidth = size.getColumns();  // Total columns
        int terminalHeight = size.getRows();   // Total rows

        // Calculate middle of the screen
        int middleScreen = terminalWidth / 2;
        int middleHeight = terminalHeight / 2;

        // Center title dynamically
        int titleStartX = middleScreen - (Constants.MENU.length() / 2);
        int titleStartY = middleHeight - (terminalHeight / 10); // Dynamic title position above middle

        // Draw the title
        gui.drawText(new Position(titleStartX, titleStartY), Constants.MENU, Constants.WHITE);

        // Dynamic spacing between menu options
        int spacing = Math.max(2, terminalHeight / 40); // Minimum 2 rows of spacing

        // Draw each menu entry dynamically centered
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            String modelText = getModel().getEntry(i);

            // Center each menu entry
            int entryStartX = middleScreen - (modelText.length() / 2);
            int entryStartY = titleStartY + 2 + (i * spacing); // Start below title with spacing

            gui.drawText(
                    new Position(entryStartX, entryStartY),
                    modelText,
                    getModel().isSelected(i) ? "#0A97B0" : Constants.WHITE
            );
        }
    }



}