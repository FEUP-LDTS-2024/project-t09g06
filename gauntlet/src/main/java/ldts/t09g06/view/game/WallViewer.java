package ldts.t09g06.view.game;


import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.game.elements.Wall;
import ldts.t09g06.view.Sprite;
import ldts.t09g06.view.SpriteLoader;

import java.io.IOException;

public class WallViewer implements ElementViewer<Wall> {
    private final Sprite sprite;

    public WallViewer(SpriteLoader spriteLoader) throws IOException{
        this.sprite = spriteLoader.get("sprites/wall/tile_0014.png");
    }

    @Override
    public void draw(Wall wall, GUI gui) {
        sprite.draw(gui,wall.getPosition().getX(),wall.getPosition().getY());
    }
}