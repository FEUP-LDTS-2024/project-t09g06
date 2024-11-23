package ldts.t09g06.control.game;

import ldts.t09g06.Game;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Position;
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
                moveMonster(monster, monster.getPosition().getCloserTo());
            this.lastMovement = time;
        }
    }

    private void moveMonster(GenericMonster monster, Position position) {
        if (getModel().isEmpty(position)) {
            monster.setPosition(position);
            if (getModel().getHero().getPosition().equals(position))
                getModel().getHero().decreaseLife(1);
        }
    }
}