package ldts.t09g06.model.game.arena;

import ldts.t09g06.model.Position;
import ldts.t09g06.model.game.elements.Wall;
import ldts.t09g06.model.game.elements.ammo.Bullet;
import ldts.t09g06.model.game.elements.ammo.GenericAmmo;
import ldts.t09g06.model.game.elements.heroes.Hero;
import ldts.t09g06.model.game.elements.monsters.GenericMonster;
import ldts.t09g06.model.game.elements.monsters.ZombieMonster;


import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private Hero hero;
    private List<GenericMonster> monsters;
    private List<Wall> walls;
    private List<GenericAmmo> bullets = new ArrayList<>();

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
    public void killMonster(List<GenericMonster> monsters, Position position){
        //is there a way to make it more efficient and just look at that position and not all monsters??
        List<GenericMonster> m = new ArrayList<>();
        for (GenericMonster monster : monsters)
            if (!monster.getPosition().equals(position))
                m.add(monster);
        setMonsters(m);
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

    public boolean wallCollision(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean monsterCollision(Position position) {
        for (GenericMonster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }

    public List<GenericAmmo> getBullets() {
        return bullets;
    }


    public void setBullets(List<GenericAmmo> bullets) {
        this.bullets = bullets;
    }

    public void addBullet(GenericAmmo bullet) {
        bullets.add(bullet);
    }

    public void removeBullets(List<GenericAmmo> bulletsToRemove) {
        bullets.removeAll(bulletsToRemove);
    }

    public void removeMonsters(List<GenericMonster> monstersToRemove) {monsters.removeAll(monstersToRemove);}
}
