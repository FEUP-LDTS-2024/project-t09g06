package ldts.t09g06.control.game;

import ldts.t09g06.Game;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.elements.Wall;
import ldts.t09g06.model.game.elements.ammo.GenericAmmo;
import ldts.t09g06.model.game.elements.ammo.Reloader;
import ldts.t09g06.model.game.elements.monsters.GenericMonster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReloaderController extends GameController{
    public ReloaderController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        updateReloaders();
    }
    private void updateReloaders() {
        List<Reloader> ReloadersToRemove = new ArrayList<>();

        boolean collided = false;

        for (Reloader reloader : getModel().getReloaders()) {
            if (reloader.collidesWith(getModel().getHero())) {
                ReloadersToRemove.add(reloader);
                collided = true;
                break;
            }
        }
        if(!ReloadersToRemove.isEmpty()) {
            for (Reloader reloader : ReloadersToRemove) {
                getModel().getHero().setAmmo_and_life(getModel().getHero().getAmmo() + reloader.getAmount_bullets(), getModel().getHero().getLife());
            }
            getModel().removeReloaders(ReloadersToRemove);}
    }
}
