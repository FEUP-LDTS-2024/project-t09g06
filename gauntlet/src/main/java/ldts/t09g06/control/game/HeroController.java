package ldts.t09g06.control.game;

import ldts.t09g06.Game;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Direction;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.elements.ammo.Bullet;
import ldts.t09g06.model.game.elements.heroes.Hero;

public class HeroController extends GameController {
    public HeroController(Arena arena) {
        super(arena);
    }

    public void moveHeroLeft() {
        moveHero(getModel().getHero().getPosition().getLeft(), Direction.LEFT);
    }

    public void moveHeroRight() {
        moveHero(getModel().getHero().getPosition().getRight(), Direction.RIGHT);
    }

    public void moveHeroUp() {
        moveHero(getModel().getHero().getPosition().getUp(), Direction.UP);
    }

    public void moveHeroDown() {
        moveHero(getModel().getHero().getPosition().getDown(), Direction.DOWN);
    }

    private void moveHero(Position position, Direction direction) {
        if (!getModel().wallCollision(position) && !getModel().monsterCollision(position)) {
            getModel().getHero().setPosition(position);
            getModel().getHero().setDirection(direction);

        }
        // If the position collides with a monster, reduce life
        if (getModel().monsterCollision(position)) {
            getModel().getHero().decreaseLife(1);
        }

    }
    public void heroShoot() {
        Position heroPosition = getModel().getHero().getPosition();
        int dx = 0;
        int dy = 0;

        switch (getModel().getHero().getDirection()) {
            case UP:    dy = -1; break;
            case DOWN:  dy = 1; break;
            case LEFT:  dx = -1; break;
            case RIGHT: dx = 1; break;
        }

        Bullet bullet = new Bullet(heroPosition.getX()+dx, heroPosition.getY()+dy, 'o', dx, dy);
        getModel().addBullet(bullet);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) moveHeroUp();
        if (action == GUI.ACTION.RIGHT) moveHeroRight();
        if (action == GUI.ACTION.DOWN) moveHeroDown();
        if (action == GUI.ACTION.LEFT) moveHeroLeft();
        if (action == GUI.ACTION.SHOOT) heroShoot();
    }
}