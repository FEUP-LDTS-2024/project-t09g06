package ldts.t09g06.control.game;

import ldts.t09g06.Game;
import ldts.t09g06.control.game.audio.AudioController;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.audio.AudioOption;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.elements.ammo.Bullet;
import ldts.t09g06.model.game.elements.monsters.GenericMonster;

import java.io.IOException;

public class BossController extends GameController {
    private long lastMovement;
    private long lastShot;

    public BossController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
        this.lastShot = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            GenericMonster boss = getModel().getBoss();
            if(!getModel().isBossDefeated()) {
                moveBoss(boss, boss.getPosition().getCloserTo(getModel(),boss.getHeroPosition()));
                this.lastMovement = time;
            }
        } if (time - lastShot > 2000) {
            bossShoot();
            this.lastShot = time;
        }
    }

    private void moveBoss(GenericMonster boss, Position position) {
        Position heroPosition = getModel().getHero().getPosition();
        //temporary
        if (!getModel().wallCollision(position) && !getModel().elementsCollision(heroPosition,position) && !getModel().isBossDefeated()) {
            boss.setPosition(position);
        }
        if (getModel().elementsCollision(heroPosition,position) && !getModel().isBossDefeated())
            getModel().getHero().decreaseLife(5);
    }

    public void bossShoot() {
            Position bossPosition = getModel().getBoss().getPosition();
            int dx = 0;
            int dy = 0;
            //temporary
            Bullet bullet = new Bullet(bossPosition.getX() + 1, bossPosition.getY() + dy, 'o', 1, 0, true);
            getModel().addBullet(bullet);
            Bullet bullet2 = new Bullet(bossPosition.getX() - 1, bossPosition.getY() + dy, 'o', -1, 0, true);
            getModel().addBullet(bullet2);
            Bullet bullet3 = new Bullet(bossPosition.getX() , bossPosition.getY() + dy - 1 , 'o', 0, -1, true);
            getModel().addBullet(bullet3);
            Bullet bullet4 = new Bullet(bossPosition.getX() , bossPosition.getY() + dy + 1, 'o', 0, 1, true);
            getModel().addBullet(bullet4);
    }

    public void setLastMovement(long lastMovement) {
        this.lastMovement = lastMovement;
    }

    public long getLastMovement() {
        return this.lastMovement;
    }
}