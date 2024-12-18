package ldts.t09g06.model.game.arena;

import ldts.t09g06.model.game.elements.Tile;
import ldts.t09g06.model.game.elements.Wall;
import ldts.t09g06.model.game.elements.ammo.Chest;
import ldts.t09g06.model.game.elements.ammo.GenericAmmo;
import ldts.t09g06.model.game.elements.ammo.LifeReloader;
import ldts.t09g06.model.game.elements.ammo.Reloader;
import ldts.t09g06.model.game.elements.heroes.Hero;
import ldts.t09g06.model.game.elements.monsters.GenericMonster;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena(int level) {
        Arena arena = new Arena(getWidth(), getHeight());
        parseGameElements();
        arena.setHero(getNewHero());
        setAmmoAndLife(level);
        arena.setMonsters(getMonsters());
        arena.setBoss(getBoss());
        arena.setReloaders(getReloaders());
        arena.setLifeReloaders(getLifeReloaders());
        arena.setChest(getChest());
        arena.setWalls(getWalls());
        arena.setTiles(getTiles());
        arena.setMin_score(getMonsters().size()*7 + 50);
//        arena.setBullets(createAmmo());

        return arena;
    }
    protected abstract void setAmmoAndLife(int level);
    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract void parseGameElements();
    public abstract Hero getNewHero();
    public abstract List<Wall> getWalls();
    public abstract List<Tile> getTiles();
    public abstract List<GenericMonster> getMonsters();
    public abstract GenericMonster getBoss();
    public abstract List<Reloader> getReloaders();
    public abstract List<LifeReloader> getLifeReloaders();
    public abstract Chest getChest();
    //public abstract List<GenericAmmo> createAmmo();


}
