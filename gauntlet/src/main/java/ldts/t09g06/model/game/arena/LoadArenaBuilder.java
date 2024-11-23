package ldts.t09g06.model.game.arena;

import ldts.t09g06.model.game.elements.Element;
import ldts.t09g06.model.game.elements.Wall;
import ldts.t09g06.model.game.elements.ammo.Bullet;
import ldts.t09g06.model.game.elements.ammo.GenericAmmo;
import ldts.t09g06.model.game.elements.heroes.Hero;
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
    List<GenericMonster> monsters = new ArrayList<>();
    protected  Hero hero;
    private static Element [][] gameElements;
    private int width;
    private int height;


    public LoadArenaBuilder(int l) throws IOException {
        this.level = l;

        URL resource = LoadArenaBuilder.class.getResource("/levels/level" + level + ".lvl");
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

    public  List<GenericAmmo> createAmmo() {
        List<GenericAmmo> ammo = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ammo.add(new Bullet(hero.getPosition().getX(), hero.getPosition().getY(),'o',0,0));
        }
        return ammo;
    }



}
