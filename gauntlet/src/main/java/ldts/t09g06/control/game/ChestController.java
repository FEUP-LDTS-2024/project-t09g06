package ldts.t09g06.control.game;

import ldts.t09g06.Game;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.elements.ammo.Chest;

public class ChestController extends GameController{
    public ChestController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        updateChest();
    }

    private void updateChest(){
        //is this necessary?
        Chest chest = getModel().getChest();
        if (chest.collidesWith(getModel().getHero()) && getModel().isBossDefeated() && getModel().getHero().getScore()>=200){
            getModel().removeChest(chest);
        }
    }
}
