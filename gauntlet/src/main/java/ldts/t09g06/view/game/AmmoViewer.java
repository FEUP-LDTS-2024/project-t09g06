package ldts.t09g06.view.game;

import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.game.elements.ammo.GenericAmmo;
import ldts.t09g06.model.game.elements.monsters.GenericMonster;
import ldts.t09g06.model.Position;

public class AmmoViewer implements ElementViewer<GenericAmmo> {
    @Override
    public void draw(GenericAmmo ammo, GUI gui) {
        gui.drawMonster(ammo.getPosition());
    }
}

