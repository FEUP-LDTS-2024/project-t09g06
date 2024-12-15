package ldts.t09g06.view.game;

import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.game.elements.ammo.GenericAmmo;
import ldts.t09g06.model.game.elements.ammo.Reloader;
import ldts.t09g06.view.Sprite;
import ldts.t09g06.view.SpriteLoader;

import java.io.IOException;

public class ReloadViewer implements ElementViewer<Reloader> {
    private final Sprite sprite;

    public ReloadViewer(SpriteLoader spriteLoader) throws IOException {
        this.sprite = spriteLoader.get("sprites/bullet/tile_0125.png");
    }

    @Override
    public void draw(Reloader reloader, GUI gui) {
        sprite.draw(gui,reloader.getPosition().getX(),reloader.getPosition().getY());
    }
}
