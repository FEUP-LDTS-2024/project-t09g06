package ldts.t09g06.view.game;

import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.game.elements.monsters.GenericMonster;
import ldts.t09g06.model.game.elements.monsters.ZombieMonster;
import ldts.t09g06.view.Sprite;
import ldts.t09g06.view.SpriteLoader;

import java.io.IOException;

public class BossViewer implements ElementViewer<GenericMonster> {
    private final Sprite sprite;

    public BossViewer(SpriteLoader spriteLoader) throws IOException {
        this.sprite = spriteLoader.get("sprites/monster/tile_0111.png");
    }

    @Override
    public void draw(GenericMonster boss, GUI gui) {
        sprite.draw(gui,boss.getPosition().getX(),boss.getPosition().getY());
    }
}