package ldts.t09g06.view.game;

import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.game.elements.monsters.GenericMonster;
import ldts.t09g06.model.game.elements.monsters.ZombieMonster;
import ldts.t09g06.view.Sprite;
import ldts.t09g06.view.SpriteLoader;

import java.io.IOException;

public class MonsterViewer implements ElementViewer<GenericMonster> {
    private final Sprite sprite;

    public MonsterViewer(SpriteLoader spriteLoader) throws IOException {
        this.sprite = spriteLoader.get("sprites/monster/tile_0109.png");
    }

    @Override
    public void draw(GenericMonster monster, GUI gui) {
        sprite.draw(gui,monster.getPosition().getX(),monster.getPosition().getY());
    }
}