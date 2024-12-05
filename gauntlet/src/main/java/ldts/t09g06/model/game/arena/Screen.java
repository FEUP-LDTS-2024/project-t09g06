package ldts.t09g06.model.game.arena;

import ldts.t09g06.model.Position;

public class Screen extends Arena {
    private final int screenWidth;
    private final int screenHeight;
    private int screenX;
    private int screenY;

    public Screen(Arena arena, int screenWidth, int screenHeight) {
        super(arena.getWidth(), arena.getHeight());
        this.setHero(arena.getHero()); // Copy hero
        this.setMonsters(arena.getMonsters()); // Copy monsters
        this.setWalls(arena.getWalls()); // Copy walls
        this.setBullets(arena.getBullets()); // Copy bullets
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.screenX = 0;
        this.screenY = 0;
    }

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public void setScreen(int x, int y) {
        this.screenX = x;
        this.screenY = y;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void followHero(Position heroPosition) {
        this.screenX = heroPosition.getX() - screenWidth / 2;
        this.screenY = heroPosition.getY() - screenHeight / 2;
    }
}
