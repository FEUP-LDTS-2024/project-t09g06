package ldts.t09g06.model.game.arena;

import ldts.t09g06.model.game.elements.Element;
import ldts.t09g06.model.game.elements.Tile;
import ldts.t09g06.model.game.elements.Wall;
import ldts.t09g06.model.game.elements.ammo.*;
import ldts.t09g06.model.game.elements.heroes.Hero;
import ldts.t09g06.model.game.elements.monsters.BossMonster;
import ldts.t09g06.model.game.elements.monsters.GenericMonster;
import ldts.t09g06.model.game.elements.monsters.ZombieMonster;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoadArenaBuilder extends ArenaBuilder {
    //have to think about how we will make levels
    private int level;
    private final List<String> lines;
    List<Wall> walls = new ArrayList<>();
    List<Tile> tiles = new ArrayList<>();
    List<GenericMonster> monsters = new ArrayList<>();
    protected  Hero hero;
    protected GenericMonster boss;
    protected Chest chest;
    List<BulletReloader> reloaders = new ArrayList<>();
    List<LifeReloader> lifeReloaders = new ArrayList<>();
    private static Element [][] gameElements;
    private int width;
    private int height;

    public LoadArenaBuilder(int l, String difficulty) throws IOException {
        this.level = l;
        URL resource = LoadArenaBuilder.class.getResource("/levels/level" + level + difficulty + ".lvl");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected void setAmmoAndLife(int level){
        switch(level){
            case 0:
                getNewHero().setAmmo_and_life(50, 10);
                getBoss().setLife(5);
                for(BulletReloader r: getReloaders()) r.setQuantity(5);
                for(LifeReloader r: getLifeReloaders()) r.setQuantity(4);
                break;
            case 1:
                getNewHero().setAmmo_and_life(40, 5);
                getBoss().setLife(10);
                for(BulletReloader r: getReloaders()) r.setQuantity(3);
                for(LifeReloader r: getLifeReloaders()) r.setQuantity(3);
                break;
            case 2:
                getNewHero().setAmmo_and_life(30, 3);
                for(BulletReloader r: getReloaders()) r.setQuantity(2);
                for(LifeReloader r: getLifeReloaders()) r.setQuantity(2);
                getBoss().setLife(15);
                break;
            case 3:
                getNewHero().setAmmo_and_life(10, 1);
                for(BulletReloader r: getReloaders()) r.setQuantity(1);
                for(LifeReloader r: getLifeReloaders()) r.setQuantity(1);
                getBoss().setLife(20);
        }
    }

    @Override
    protected int getWidth() {
        width = lines.get(0).length();
        return width;
    }

    @Override
    protected int getHeight() {
        height = lines.size();
        return height;
    }

    @Override
    protected void parseGameElements() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                char currChar = line.charAt(x);
                switch (currChar) {
                    case '#':
                        walls.add(new Wall(x, y, currChar));
                        break;
                    case 'H':
                        hero = new Hero(x, y, currChar);
                        break;
                    case 'M':
                        monsters.add(new ZombieMonster(x, y, currChar));
                        break;
                    case 'B':
                        boss = new BossMonster(x, y, currChar) {
                        };
                        break;
                    case 'C':
                        chest = new Chest(x, y, currChar) {
                        };
                        break;
                    case 'R':
                        reloaders.add(new BulletReloader(x,y,currChar));
                        break;
                    case 'L':
                        lifeReloaders.add(new LifeReloader(x, y, currChar));
                    default:
                        break;
                }
            }
        }
    }

    public Hero getNewHero() {
        return hero;
    }
    public List<Wall> getWalls() {
        return walls;
    }
    public  List<GenericMonster> getMonsters(){
        return monsters;
    }
    public GenericMonster getBoss() {return boss;}
    public List<BulletReloader> getReloaders(){return reloaders;}
    public List<LifeReloader> getLifeReloaders(){return lifeReloaders;}
    public Chest getChest(){return chest;}
    public List<Tile> getTiles() {return tiles;}
//    public  List<GenericAmmo> createAmmo() {
//        List<GenericAmmo> ammo = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            ammo.add(new Bullet(hero.getPosition().getX()+i, hero.getPosition().getY()+i,'o',0,0));
//        }
//        return ammo;
//    }
}
