package ldts.t09g06.model.game.arena;

import ldts.t09g06.model.game.elements.Wall;
import ldts.t09g06.model.game.elements.heroes.Hero;
import ldts.t09g06.model.game.elements.monsters.GenericMonster;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        parseGameElements();
        arena.setHero(getNewHero());
        arena.setMonsters(getMonsters());
        arena.setWalls(getWalls());

        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract void parseGameElements();
    public abstract Hero getNewHero();
    public abstract List<Wall> getWalls();

    public abstract List<GenericMonster> getMonsters();



}
