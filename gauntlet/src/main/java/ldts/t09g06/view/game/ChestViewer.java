package ldts.t09g06.view.game;

import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.game.elements.ammo.Chest;
import ldts.t09g06.model.game.elements.monsters.GenericMonster;
import ldts.t09g06.model.game.elements.monsters.ZombieMonster;
import ldts.t09g06.view.Sprite;
import ldts.t09g06.view.SpriteLoader;

import java.io.IOException;

public class ChestViewer implements ElementViewer<Chest> {
    private final Sprite sprite;

    public ChestViewer(SpriteLoader spriteLoader) throws IOException {
        this.sprite = spriteLoader.get("sprites/chest/tile_0089.png");
    }

    @Override
    public void draw(Chest chest, GUI gui) {
        sprite.draw(gui,chest.getPosition().getX(),chest.getPosition().getY());
    }
}