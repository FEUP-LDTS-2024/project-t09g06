package ldts.t09g06.view;

import ldts.t09g06.view.game.WallViewer;

import java.io.IOException;

public class ViewerManager {
    private final WallViewer wallViewer;

    public ViewerManager(SpriteLoader spriteLoader) throws IOException {
        this.wallViewer = new WallViewer(spriteLoader);
    }

    public WallViewer getWallViewer() {return wallViewer;}
}
