package ldts.t09g06.control.game;

import ldts.t09g06.Game;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Constants;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.leaderboard.InsertName;
import ldts.t09g06.model.leaderboard.Leaderboard;
import ldts.t09g06.model.menu.Menu;
import ldts.t09g06.states.InsertNameState;
import ldts.t09g06.states.LeaderboardState;
import ldts.t09g06.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final HeroController heroController;
    private final MonsterController monsterController;
    private final AmmoController ammoController;
    public ArenaController(Arena arena) {
        super(arena);

        this.heroController = new HeroController(arena);
        this.monsterController = new MonsterController(arena);
        this.ammoController = new AmmoController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT) {
            game.getGui().resizeScreen(Constants.menuWidth, Constants.menuHeight);
            game.setState(new MenuState(new Menu()));

        }
        else if(getModel().getHero().getLife() == 0){
            game.setState(new InsertNameState(new InsertName(getModel().getHero())));
        }
        else {
            heroController.step(game, action, time);
            monsterController.step(game, action, time);
            ammoController.step(game, action, time);
        }
    }

    public HeroController getHeroController() {
        return heroController;
    }

    public MonsterController getMonsterController() {
        return monsterController;
    }

    public AmmoController getAmmoController() {
        return ammoController;
    }
}
