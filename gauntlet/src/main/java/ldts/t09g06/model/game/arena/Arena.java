package ldts.t09g06.model.game.arena;

import ldts.t09g06.model.Position;
import ldts.t09g06.model.game.elements.Wall;
import ldts.t09g06.model.game.elements.heroes.Hero;
import ldts.t09g06.model.game.elements.monsters.GenericMonster;
import ldts.t09g06.model.game.elements.monsters.ZombieMonster;


import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private Hero hero;
    private List<GenericMonster> monsters;
    private List<Wall> walls;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public void setHero(Hero hero) {
        this.hero = hero;
    }
    public void setMonsters(List<GenericMonster> monsters) {
        this.monsters = monsters;
    }
    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Hero getHero() {
        return hero;
    }
    public List<GenericMonster> getMonsters() {
        return monsters;
    }
    public List<Wall> getWalls() {
        return walls;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }
    public boolean isMonster(Position position) {
        for (GenericMonster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }
}
