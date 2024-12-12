package ldts.t09g06.view.menu;

import com.googlecode.lanterna.TerminalSize;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Constants;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.menu.MenuLevel;
import ldts.t09g06.model.menu.MenuSettings;
import ldts.t09g06.view.Viewer;

public class MenuSettingsViewer extends Viewer<MenuSettings> {
    public MenuSettingsViewer(MenuSettings menu) {
        super(menu);
    }

    @Override
    public void drawModel(GUI gui) {

        TerminalSize size = gui.getScreen().getTerminalSize();
        int height = size.getRows();
        int width = size.getColumns();
        int middleScreen = width / 2;
        int middleHeight = height/2;
        int textStart = middleScreen - Constants.MENU.length() / 2;
        gui.drawText(new Position(textStart-8, middleHeight-3), "----- Settings -----", "#074799");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {

            String modelText = getModel().getEntry(i);
            textStart = middleScreen - modelText.length() / 2;
            gui.drawText(
                    new Position(textStart, middleHeight + i),
                    modelText,
                    getModel().isSelected(i) ? "#0A97B0" : Constants.WHITE);
        }
        gui.drawText(new Position(width-26, height-1), "press 'q' to save and exit", Constants.WHITE);
    }
}
