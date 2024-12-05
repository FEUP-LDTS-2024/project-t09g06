package ldts.t09g06.states;


import ldts.t09g06.control.Controller;
import ldts.t09g06.control.game.ArenaController;
import ldts.t09g06.control.game.ScreenController;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.arena.Screen;
import ldts.t09g06.view.Viewer;
import ldts.t09g06.view.game.GameViewer;

import javax.swing.text.View;

public class GameState extends State<Screen> {
    public GameState(Screen screen) {
        super(screen);
    }

    @Override
    protected Viewer<Screen> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Screen> getController() {
        return new ScreenController(getModel());
    }
}
