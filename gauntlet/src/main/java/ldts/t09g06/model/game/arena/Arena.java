package ldts.t09g06.model.game.arena;

import ldts.t09g06.model.Position;
import ldts.t09g06.model.game.elements.Element;
import ldts.t09g06.model.game.elements.Tile;
import ldts.t09g06.model.game.elements.Wall;
import ldts.t09g06.model.game.elements.ammo.*;
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
    private GenericMonster boss;
    private List<BulletReloader> bulletReloaders;
    private List<LifeReloader> lifeReloaders;
    private List<Wall> walls;
    private List<GenericAmmo> bullets = new ArrayList<>();
    private List<Tile> tiles;
    private Chest chest;
    //temporary boss removal
    private int min_score;

    private boolean bossDefeated = false;

    public int getMin_score() {
        return min_score;
    }

    public void setMin_score(int min_score) {
        this.min_score = min_score;
    }

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
    public void setBoss(GenericMonster boss) {
        this.boss = boss;
    }
    public void setChest(Chest chest) {
        this.chest = chest;
    }
    public void setReloaders(List<BulletReloader> reloaders){this.bulletReloaders = reloaders;}
    public void setLifeReloaders(List<LifeReloader> lifeReloaders){this.lifeReloaders = lifeReloaders;}
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

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
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
    public GenericMonster getBoss() {
        return boss;
    }
    public Chest getChest(){
        return chest;
    }
    public List<BulletReloader> getReloaders() {
        return bulletReloaders;
    }
    public List<LifeReloader> getLifeReloaders(){ return lifeReloaders;}
    public List<Wall> getWalls() {
        return walls;
    }
    public List<Tile> getTiles() {return tiles;}

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

    public boolean isBossDefeated() {
        return bossDefeated;
    }

    public boolean bossCollision(Position position) {
        return boss.getPosition().equals(position);
    }

    public boolean elementsCollision(Position position1, Position position2){
        return position1.equals(position2);
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
    public void removeReloaders(List<BulletReloader> reloadersToRemove){
        bulletReloaders.removeAll(reloadersToRemove);
    }
    public void removeLifeReloaders(List<LifeReloader> reloadersToRemove){
        lifeReloaders.removeAll(reloadersToRemove);
    }

    public void removeMonsters(List<GenericMonster> monstersToRemove) {monsters.removeAll(monstersToRemove);}

    public void removeBoss(GenericMonster boss) {
        boss.setPosition(new Position(-1, -1));
        this.bossDefeated=true;
    }
    public void removeChest(Chest chest) {
        chest.setPosition(new Position(-2, -2));
    }
}
