package ldts.t09g06.control.game;

import ldts.t09g06.Game;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.elements.ammo.LifeReloader;
import ldts.t09g06.model.game.elements.ammo.Reloader;

import java.util.ArrayList;
import java.util.List;

public class LifeReloaderController extends GameController{
    public LifeReloaderController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        updateReloaders();
    }
    private void updateReloaders() {
        List<LifeReloader> ReloadersToRemove = new ArrayList<>();

        for (LifeReloader reloader : getModel().getLifeReloaders()) {
            if (reloader.collidesWith(getModel().getHero())) {
                ReloadersToRemove.add(reloader);
                break;
            }
        }
        if(!ReloadersToRemove.isEmpty()) {
            for (LifeReloader reloader : ReloadersToRemove) {
                getModel().getHero().setAmmo_and_life(getModel().getHero().getAmmo(), getModel().getHero().getLife() + reloader.getAmount_life());
            }
            getModel().removeLifeReloaders(ReloadersToRemove);}
    }
}
