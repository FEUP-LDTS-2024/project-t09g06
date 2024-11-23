package ldts.t09g06.control.game;

import ldts.t09g06.control.Controller;
import ldts.t09g06.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
