package ldts.t09g06.view.game;

import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.game.elements.ammo.GenericAmmo;
import ldts.t09g06.model.game.elements.heroes.Hero;
import ldts.t09g06.model.game.elements.monsters.GenericMonster;
import ldts.t09g06.model.Position;
import ldts.t09g06.view.Sprite;
import ldts.t09g06.view.SpriteLoader;

import java.io.IOException;

public class AmmoViewer implements ElementViewer<GenericAmmo> {
        private final Sprite sprite;

        public AmmoViewer(SpriteLoader spriteLoader) throws IOException {
            this.sprite = spriteLoader.get("sprites/bullet/tile_0125.png");
        }

        @Override
        public void draw(GenericAmmo ammo, GUI gui) {
            sprite.draw(gui,ammo.getPosition().getX(),ammo.getPosition().getY());
        }
    }

