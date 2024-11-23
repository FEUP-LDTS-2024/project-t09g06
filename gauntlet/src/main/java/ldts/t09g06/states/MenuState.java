package ldts.t09g06.states;

import ldts.t09g06.control.Controller;
import ldts.t09g06.control.menu.MenuController;
import ldts.t09g06.model.menu.Menu;
import ldts.t09g06.view.Viewer;
import ldts.t09g06.view.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}