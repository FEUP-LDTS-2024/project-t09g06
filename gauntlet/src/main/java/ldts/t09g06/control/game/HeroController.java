package ldts.t09g06.control.game;

import ldts.t09g06.Game;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Direction;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.elements.ammo.Bullet;
import ldts.t09g06.model.game.elements.heroes.Hero;
import ldts.t09g06.gui.LanternaGUI;

public class HeroController extends GameController {
    public HeroController(Arena arena) {
        super(arena);
    }

    public void moveHeroLeft(Game game) {
        moveHero(getModel().getHero().getPosition().getLeft(), Direction.LEFT, game);
    }

    public void moveHeroRight(Game game) {
        moveHero(getModel().getHero().getPosition().getRight(), Direction.RIGHT, game);
    }

    public void moveHeroUp(Game game) {
        moveHero(getModel().getHero().getPosition().getUp(), Direction.UP, game);
    }

    public void moveHeroDown(Game game) {
        moveHero(getModel().getHero().getPosition().getDown(), Direction.DOWN, game);
    }

    private void moveHero(Position position, Direction direction, Game game) {
        if (!getModel().wallCollision(position) && !getModel().monsterCollision(position)) {
            getModel().getHero().setPosition(position);
            game.getGui().setTranslation(getModel().getHero().getPosition());
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
        if (action == GUI.ACTION.UP) moveHeroUp(game);
        if (action == GUI.ACTION.RIGHT) moveHeroRight(game);
        if (action == GUI.ACTION.DOWN) moveHeroDown(game);
        if (action == GUI.ACTION.LEFT) moveHeroLeft(game);
        if (action == GUI.ACTION.SHOOT) heroShoot();
    }
}