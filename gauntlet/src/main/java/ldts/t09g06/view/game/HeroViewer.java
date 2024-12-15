package ldts.t09g06.view.game;


import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Direction;
import ldts.t09g06.model.game.elements.heroes.Hero;
import ldts.t09g06.view.Sprite;
import ldts.t09g06.view.SpriteLoader;

import java.io.IOException;
import java.util.EnumMap;

public class HeroViewer implements ElementViewer<Hero> {
    private final EnumMap<Direction, Sprite> sprites;

    public HeroViewer(SpriteLoader spriteLoader) throws IOException{
        this.sprites = new EnumMap<>(Direction.class);
        this.sprites.put(Direction.UP, spriteLoader.get("sprites/hero/sprite_final_4.png"));
        this.sprites.put(Direction.DOWN, spriteLoader.get("sprites/hero/down.png"));
        this.sprites.put(Direction.LEFT, spriteLoader.get("sprites/hero/sprite_shitl.png"));
        this.sprites.put(Direction.RIGHT, spriteLoader.get("sprites/hero/sprite_shitr.png"));
    }

    @Override
    public void draw(Hero hero, GUI gui) {
        Direction direction = hero.getDirection();
        Sprite sprite = sprites.get(direction);
        if(sprite!=null) {
            sprite.draw(gui, hero.getPosition().getX(), hero.getPosition().getY());
        }
    }
}