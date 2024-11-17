package ldts.t09g06;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;
    private List<Monster> monsters;
    private boolean gameOver = false;
    public Arena(int w, int h){
        width = w;
        height = h;
        hero = new Hero(10,10);
        this.walls = createWalls();
        this.monsters = createMonsters();
    }
    public boolean isGameOver(){
        return gameOver;
    }
    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return monsters;
    }
    private List<Monster> moveMonsters(){
        List<Monster> monsters_ = new ArrayList<>();
        for(Monster monster : monsters) {
            Position p = monster.move();
            if(canElementMove(p)) monsters_.add(new Monster(p));
            else monsters_.add(monster);
        }
        return monsters_;
    }
    private boolean verifyMonsterCollisions(){
        for(Monster monster : monsters){
            if(monster.getPosition().equals(hero.getPosition())) return true;
        }
        return false;
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#0e6655"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for (Wall wall : walls) wall.draw(graphics);
        hero.draw(graphics);
        if(verifyMonsterCollisions()){
            System.out.println("GAME OVER");
            gameOver = true;
        }
        monsters = moveMonsters();
        if(verifyMonsterCollisions()){
            System.out.println("GAME OVER");
            gameOver=true;
        }
        for (Monster monster : monsters) monster.draw(graphics);
    }
    public void processKey(KeyStroke key) throws IOException {
        System.out.println(key);

        switch (key.getKeyType()){
            case ArrowDown -> moveHero(hero.moveDown());
            case ArrowUp -> moveHero(hero.moveUp());
            case ArrowLeft -> moveHero(hero.moveLeft());
            case ArrowRight -> moveHero(hero.moveRight());
        }
    }
    public void moveHero(Position position) {
        if (canElementMove(position))
            hero.setPosition(position);
    }

    private boolean canElementMove(Position position){
        for (Wall wall : walls)
            if(wall.getPosition().equals(position)) return false;
        return true;
    }


    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
}
