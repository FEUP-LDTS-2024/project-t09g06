package ldts.t09g06.states;

import ldts.t09g06.control.Controller;
import ldts.t09g06.control.menu.MenuLevelController;
import ldts.t09g06.control.menu.MenuSettingsController;
import ldts.t09g06.model.menu.MenuLevel;
import ldts.t09g06.model.menu.MenuSettings;
import ldts.t09g06.view.Viewer;
import ldts.t09g06.view.menu.MenuLevelViewer;
import ldts.t09g06.view.menu.MenuSettingsViewer;

public class MenuSettingsState extends State<MenuSettings>{
    public MenuSettingsState(MenuSettings model) {
        super(model);
    }

    @Override
    protected Viewer<MenuSettings> getViewer() {
        return new MenuSettingsViewer(getModel());
    }

    @Override
    protected Controller<MenuSettings> getController() {
        return new MenuSettingsController(getModel());
    }
}
