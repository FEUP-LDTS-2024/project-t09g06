package ldts.t09g06.model.game.arena;

import ldts.t09g06.model.game.elements.Wall;
import ldts.t09g06.model.game.elements.heroes.Hero;
import ldts.t09g06.model.game.elements.monsters.GenericMonster;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setHero(createHero());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());

        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<GenericMonster> createMonsters();

    protected abstract Hero createHero();
}
