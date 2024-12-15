package ldts.t09g06.view.menu;

import com.googlecode.lanterna.TerminalSize;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Constants;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.menu.MenuLevel;
import ldts.t09g06.model.menu.MenuSettings;
import ldts.t09g06.view.Viewer;
import ldts.t09g06.view.ViewerManager;

public class MenuSettingsViewer extends Viewer<MenuSettings> {
    public MenuSettingsViewer(MenuSettings menu, ViewerManager viewerManager) {
        super(menu);
    }

    @Override
    public void drawModel(GUI gui) {

        TerminalSize size = gui.getScreen().getTerminalSize();
        int height = size.getRows();
        int width = size.getColumns();
        int middleScreen = width / 2;
        int middleHeight = height/2;
        int textStart = middleScreen - "----- SETTINGS -----".length() / 2;
        gui.drawText(new Position(textStart, middleHeight-3), "----- SETTINGS -----", "#074799");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {

            String modelText = getModel().getEntry(i);
            textStart = middleScreen - modelText.length() / 2;
            gui.drawText(
                    new Position(textStart, middleHeight + i),
                    modelText,
                    getModel().isSelected(i) ? "#0A97B0" : Constants.WHITE);
        }
        gui.drawText(new Position( middleScreen - "back to menu - press 'q'".length() / 2, height-4), "back to menu - press 'q'", Constants.WHITE);
    }
}
