package ldts.t09g06.states;

import ldts.t09g06.control.Controller;
import ldts.t09g06.control.menu.MenuController;
import ldts.t09g06.control.menu.MenuLevelController;
import ldts.t09g06.model.menu.Menu;
import ldts.t09g06.model.menu.MenuLevel;
import ldts.t09g06.view.SpriteLoader;
import ldts.t09g06.view.Viewer;
import ldts.t09g06.view.ViewerManager;
import ldts.t09g06.view.menu.MenuLevelViewer;
import ldts.t09g06.view.menu.MenuViewer;

import java.io.IOException;

public class MenuLevelState extends State<MenuLevel> {
    public MenuLevelState(MenuLevel model, SpriteLoader spriteLoader) throws IOException {
        super(model,spriteLoader);
    }

    @Override
    protected Viewer<MenuLevel> getViewer(ViewerManager viewerManager) {
        return new MenuLevelViewer(getModel(),viewerManager);
    }

    @Override
    protected Controller<MenuLevel> getController() {
        return new MenuLevelController(getModel());
    }
}