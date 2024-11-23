package ldts.t09g06.control.game;

import ldts.t09g06.Game;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.elements.ammo.GenericAmmo;
import ldts.t09g06.model.game.elements.monsters.GenericMonster;

import java.io.IOException;

public class AmmoController extends GameController {
    //save last direction hero walked and shoot that way
    public AmmoController(Arena arena) {
        super(arena);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
    }

    private void moveAmmo(GenericAmmo ammo, Position position) {
        if (getModel().isEmpty(position)) {
            ammo.setPosition(position);
            getModel().killMonster(getModel().getMonsters(), position);
        }
    }
}