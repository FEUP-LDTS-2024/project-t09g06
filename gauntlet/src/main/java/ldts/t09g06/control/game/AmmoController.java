package ldts.t09g06.control.game;

import ldts.t09g06.Game;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.elements.Wall;
import ldts.t09g06.model.game.elements.ammo.GenericAmmo;
import ldts.t09g06.model.game.elements.monsters.GenericMonster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AmmoController extends GameController {
    //save last direction hero walked and shoot that way
    public AmmoController(Arena arena) {
        super(arena);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        updateAmmo();
    }

    private void updateAmmo() {
        List<GenericAmmo> bulletsToRemove = new ArrayList<>();
        List<Wall> walls = getModel().getWalls();
        List<GenericMonster> monsters = getModel().getMonsters();
        GenericMonster boss = getModel().getBoss();
        List<GenericMonster> monstersToRemove = new ArrayList<>();

        boolean collided = false;

        for (GenericAmmo bullet : getModel().getBullets()) {
            Position nextPosition =  getNextPosition(bullet);

            for (Wall wall : walls) {
                if (bullet.collidesWith(wall)) {
                    bulletsToRemove.add(bullet);
                    collided = true;
                    break;
                }
            }

            if(!collided) {
                for (GenericMonster monster : monsters) {
                    if (bullet.collidesWith(monster)) {
                        monstersToRemove.add(monster);
                        bulletsToRemove.add(bullet);
                        getModel().getHero().increase_score(10);
                        collided = true;
                        break;
                    }
                    if(bullet.collidesWith(boss)){
                        getModel().getBoss().decreaseLife(1);
                        bulletsToRemove.add(bullet);
                        if(getModel().getBoss().getLife()<=0) {
                            getModel().removeBoss(boss);
                            getModel().getHero().increase_score(50);
                        }
                        collided = true;
                        break;
                    }
                }
            }
            if(!collided) bullet.setPosition(nextPosition);
        }
        if(!bulletsToRemove.isEmpty()) getModel().removeBullets(bulletsToRemove);
        if(!monstersToRemove.isEmpty())getModel().removeMonsters(monstersToRemove);

    }

    public Position getNextPosition(GenericAmmo ammo) {
        Position next = new Position(ammo.getPosition().getX()+ammo.getDx(),ammo.getPosition().getY()+ ammo.getDy());
        return next;
    }
}