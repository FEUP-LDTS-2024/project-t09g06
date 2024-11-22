package ldts.t09g06.states;


import ldts.t09g06.control.Controller;
import ldts.t09g06.control.game.ArenaController;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.view.Viewer;
import ldts.t09g06.view.game.GameViewer;

import javax.swing.text.View;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}