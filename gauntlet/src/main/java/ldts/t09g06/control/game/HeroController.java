package ldts.t09g06.control.game;

import ldts.t09g06.Game;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.game.arena.Arena;

public class HeroController extends GameController {
    public HeroController(Arena arena) {
        super(arena);
    }

    public void moveHeroLeft() {
        moveHero(getModel().getHero().getPosition().getLeft());
    }

    public void moveHeroRight() {
        moveHero(getModel().getHero().getPosition().getRight());
    }

    public void moveHeroUp() {
        moveHero(getModel().getHero().getPosition().getUp());
    }

    public void moveHeroDown() {
        moveHero(getModel().getHero().getPosition().getDown());
    }

    private void moveHero(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getHero().setPosition(position);
            if (getModel().isMonster(position)) getModel().getHero().decreaseLife(1);
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) moveHeroUp();
        if (action == GUI.ACTION.RIGHT) moveHeroRight();
        if (action == GUI.ACTION.DOWN) moveHeroDown();
        if (action == GUI.ACTION.LEFT) moveHeroLeft();
    }
}