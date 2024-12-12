package ldts.t09g06.states;

import ldts.t09g06.control.Controller;
import ldts.t09g06.control.menu.MenuController;
import ldts.t09g06.model.menu.Menu;
import ldts.t09g06.view.SpriteLoader;
import ldts.t09g06.view.Viewer;
import ldts.t09g06.view.ViewerManager;
import ldts.t09g06.view.menu.MenuViewer;

import java.io.IOException;

public class MenuState extends State<Menu> {
    public MenuState(Menu model, SpriteLoader spriteLoader) throws IOException {
        super(model,spriteLoader);
    }

    @Override
    protected Viewer<Menu> getViewer(ViewerManager viewerManager) {
        return new MenuViewer(getModel(),viewerManager);
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}