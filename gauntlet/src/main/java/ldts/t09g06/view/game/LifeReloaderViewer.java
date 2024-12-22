package ldts.t09g06.view.game;

import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.game.elements.ammo.LifeReloader;
import ldts.t09g06.model.game.elements.ammo.Reloader;
import ldts.t09g06.view.Sprite;
import ldts.t09g06.view.SpriteLoader;

import java.io.IOException;

public class LifeReloaderViewer implements ElementViewer<LifeReloader> {
    private final Sprite sprite;

    public LifeReloaderViewer(SpriteLoader spriteLoader) throws IOException {
        this.sprite = spriteLoader.get("sprites/Reloaders/tile_0116.png");
    }

    @Override
    public void draw(LifeReloader lifeReloader, GUI gui) {
        sprite.draw(gui,lifeReloader.getPosition().getX(),lifeReloader.getPosition().getY());
    }
}
