package ldts.t09g06.control.game;

import ldts.t09g06.Game;
import ldts.t09g06.control.audio.AudioController;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.audio.AudioOption;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.elements.Wall;
import ldts.t09g06.model.game.elements.ammo.GenericAmmo;
import ldts.t09g06.model.game.elements.heroes.Hero;
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
        List<GenericMonster> monstersToRemove = new ArrayList<>();
        List<Wall> walls = getModel().getWalls();
        List<GenericMonster> monsters = getModel().getMonsters();
        GenericMonster boss = getModel().getBoss();
        Hero hero = getModel().getHero();

        for (GenericAmmo bullet : getModel().getBullets()) {
            Position nextPosition = getNextPosition(bullet);
            boolean collided = false;

            if (bullet.isFromBoss()) {
                if (bullet.collidesWith(hero)) {
                    HeroHitByBossBullet(hero, bullet, bulletsToRemove);
                    collided = true;
                }
                collided = WallCollision(bullet, nextPosition, walls, bulletsToRemove);
            }
            else {
                collided = MonsterCollisions(bullet, monsters, monstersToRemove, bulletsToRemove, hero);
                if (!collided && bullet.collidesWith(boss)) {
                    BossCollision(bullet, boss, bulletsToRemove, hero);
                    collided = true;
                }
                if (!collided) {
                    collided = WallCollision(bullet, nextPosition, walls, bulletsToRemove);
                }
            }

            if (!collided) {
                bullet.setPosition(nextPosition);
            }
        }


        if (!bulletsToRemove.isEmpty()) getModel().removeBullets(bulletsToRemove);
        if (!monstersToRemove.isEmpty()) getModel().removeMonsters(monstersToRemove);
    }

    private boolean WallCollision(GenericAmmo bullet, Position nextPosition, List<Wall> walls, List<GenericAmmo> bulletsToRemove) {
        for (Wall wall : walls) {
            if (nextPosition.collidesWith(wall)) {
                bulletsToRemove.add(bullet);
                return true;
            }
        }
        return false;
    }

    private void HeroHitByBossBullet(Hero hero, GenericAmmo bullet, List<GenericAmmo> bulletsToRemove) {
        AudioController.getInstance().playAudio(AudioOption.MONSTER_ATACK);
        hero.decreaseLife(1);
        bulletsToRemove.add(bullet);
    }

    private boolean MonsterCollisions(GenericAmmo bullet, List<GenericMonster> monsters, List<GenericMonster> monstersToRemove, List<GenericAmmo> bulletsToRemove, Hero hero) {
        for (GenericMonster monster : monsters) {
            if (bullet.collidesWith(monster)) {
                AudioController.getInstance().playAudio(AudioOption.MONSTER_HIT);
                monstersToRemove.add(monster);
                bulletsToRemove.add(bullet);
                hero.increase_score(10);
                return true;
            }
        }
        return false;
    }

    private void BossCollision(GenericAmmo bullet, GenericMonster boss, List<GenericAmmo> bulletsToRemove, Hero hero) {
        AudioController.getInstance().playAudio(AudioOption.MONSTER_HIT);
        boss.decreaseLife(1);
        bulletsToRemove.add(bullet);
        if (boss.getLife() <= 0) {
            getModel().removeBoss(boss);
            hero.increase_score(50);
        }
    }

    public Position getNextPosition(GenericAmmo ammo) {
        return new Position(ammo.getPosition().getX()+ammo.getDx(),ammo.getPosition().getY()+ ammo.getDy());
    }
}