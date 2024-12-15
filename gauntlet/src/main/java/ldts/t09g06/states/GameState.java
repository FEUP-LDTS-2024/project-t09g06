package ldts.t09g06.states;


import ldts.t09g06.control.Controller;
import ldts.t09g06.control.game.ArenaController;
import ldts.t09g06.control.game.audio.AudioController;
import ldts.t09g06.model.audio.AudioOption;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.view.SpriteLoader;
import ldts.t09g06.view.Viewer;
import ldts.t09g06.view.ViewerManager;
import ldts.t09g06.view.game.GameViewer;

import javax.swing.text.View;
import java.io.IOException;

public class GameState extends State<Arena> {
    public GameState(Arena arena, SpriteLoader spriteLoader) throws IOException {
        super(arena,spriteLoader);
    }

    @Override
    protected Viewer<Arena> getViewer(ViewerManager viewerManager) {
        return new GameViewer(getModel(),viewerManager);
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}