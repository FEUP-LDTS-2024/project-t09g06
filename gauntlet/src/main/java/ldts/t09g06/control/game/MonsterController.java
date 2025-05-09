package ldts.t09g06.control.game;

import ldts.t09g06.Game;
import ldts.t09g06.control.audio.AudioController;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.audio.AudioOption;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.elements.monsters.GenericMonster;

import java.io.IOException;

public class MonsterController extends GameController {
    private long lastMovement;

    public MonsterController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (GenericMonster monster : getModel().getMonsters())
                moveMonster(monster, monster.getPosition().getCloserTo(getModel(),monster.getHeroPosition()));
            this.lastMovement = time;
        }
    }

    private void moveMonster(GenericMonster monster, Position position) {
        Position heroPosition = getModel().getHero().getPosition();
        if (!getModel().wallCollision(position) && !getModel().elementsCollision(heroPosition,position)) {
            monster.setPosition(position);
        }
        if (getModel().elementsCollision(heroPosition,position)) {
            AudioController.getInstance().playAudio(AudioOption.MONSTER_ATACK);
            getModel().getHero().decreaseLife(1);
        }
    }
    public void setLastMovement(long lastMovement) {
        this.lastMovement = lastMovement;
    }

    public long getLastMovement() {
        return this.lastMovement;
    }
}