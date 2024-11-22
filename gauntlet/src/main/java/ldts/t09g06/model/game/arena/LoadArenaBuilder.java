package ldts.t09g06.model.game.arena;

import ldts.t09g06.model.game.elements.Wall;
import ldts.t09g06.model.game.elements.heroes.Hero;
import ldts.t09g06.model.game.elements.monsters.GenericMonster;
import ldts.t09g06.model.game.elements.monsters.ZombieMonster;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoadArenaBuilder extends ArenaBuilder {
    //have to think about how we will make levels
    private final Random rng;
    private final int width;
    private final int height;
    private final int numberOfMonsters;

    public LoadArenaBuilder(int w, int h, int n) throws IOException {
        this.numberOfMonsters = n;
        this.height = h;
        this.width = w;
        this.rng = new Random();
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return height;
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int x = 0; x < width; x++) {
            walls.add(new Wall(x, 0));
            walls.add(new Wall(x, height - 1));
        }

        for (int y = 1; y < height - 1; y++) {
            walls.add(new Wall(0, y));
            walls.add(new Wall(width - 1, y));
        }

        return walls;
    }

    @Override
    protected List<GenericMonster> createMonsters() {
        List<GenericMonster> monsters = new ArrayList<>();

        while (monsters.size() < numberOfMonsters)
            monsters.add(new ZombieMonster(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return monsters;
    }

    @Override
    protected Hero createHero() {
        return new Hero(2, height-2);
    }

}
