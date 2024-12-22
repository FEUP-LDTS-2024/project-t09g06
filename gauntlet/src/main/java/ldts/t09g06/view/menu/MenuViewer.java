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
        TerminalSize size = gui.getScreen().getTerminalSize();
        int terminalWidth = size.getColumns();
        int terminalHeight = size.getRows();
        int middleScreen = terminalWidth / 2;
        int middleHeight = terminalHeight / 2;
        int titleStartX = middleScreen - (Constants.MENU.length() / 2);
        int titleStartY = middleHeight - (terminalHeight / 10);

        gui.drawText(new Position(titleStartX, titleStartY), Constants.MENU, Constants.WHITE);

        int spacing = Math.max(2, terminalHeight / 40);

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            String modelText = getModel().getEntry(i);

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