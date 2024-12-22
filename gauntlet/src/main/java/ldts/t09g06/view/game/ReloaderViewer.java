package ldts.t09g06.view.game;

import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.game.elements.ammo.Bullet;
import ldts.t09g06.model.game.elements.ammo.BulletReloader;
import ldts.t09g06.model.game.elements.ammo.Reloader;
import ldts.t09g06.view.Sprite;
import ldts.t09g06.view.SpriteLoader;

import java.io.IOException;

public class ReloaderViewer implements ElementViewer<BulletReloader> {
    private final Sprite sprite;

    public ReloaderViewer(SpriteLoader spriteLoader) throws IOException {
        this.sprite = spriteLoader.get("sprites/bullet/tile_0062.png");
    }

    @Override
    public void draw(BulletReloader reloader, GUI gui) {
        sprite.draw(gui,reloader.getPosition().getX(),reloader.getPosition().getY());
    }
}
