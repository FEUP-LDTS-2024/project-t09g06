package ldts.t09g06.control.game;

import ldts.t09g06.Game;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.elements.monsters.GenericMonster;

import java.io.IOException;

public class BossController extends GameController {
    private long lastMovement;

    public BossController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            GenericMonster boss = getModel().getBoss();
            if(boss!=null) {
                moveBoss(boss, boss.getPosition().getCloserTo());
                this.lastMovement = time;
            }
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

    public void setLastMovement(long lastMovement) {
        this.lastMovement = lastMovement;
    }

    public long getLastMovement() {
        return this.lastMovement;
    }
}