package ldts.t09g06.view.game;

import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.game.elements.Tile;
import ldts.t09g06.view.Sprite;
import ldts.t09g06.view.SpriteLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TileViewer implements ElementViewer<Tile>{
    private final Map<Character,Sprite> MapTiles;

    public TileViewer(SpriteLoader spriteLoader) throws IOException{
        MapTiles = new HashMap<>();
        MapTiles.put('J', spriteLoader.get("sprites/map_tiles/tile_0042.png"));
        MapTiles.put('G', spriteLoader.get("sprites/map_tiles/tile_0049.png"));
    }

    @Override
    public void draw(Tile tile, GUI gui) {
        Sprite sprite = MapTiles.get(tile.getElement());
        sprite.draw(gui, tile.getPosition().getX(), tile.getPosition().getY());
    }

}
