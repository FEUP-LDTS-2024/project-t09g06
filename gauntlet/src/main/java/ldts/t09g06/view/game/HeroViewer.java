package ldts.t09g06.view.game;


import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.game.elements.heroes.Hero;
import ldts.t09g06.view.Sprite;
import ldts.t09g06.view.SpriteLoader;

import java.io.IOException;

public class HeroViewer implements ElementViewer<Hero> {
    private final Sprite sprite;

    public HeroViewer(SpriteLoader spriteLoader) throws IOException{
        this.sprite = spriteLoader.get("sprites/hero/tile_0085.png");
    }

    @Override
    public void draw(Hero hero, GUI gui) {
        sprite.draw(gui,hero.getPosition().getX(),hero.getPosition().getY());
    }
}