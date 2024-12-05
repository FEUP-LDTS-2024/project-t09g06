package ldts.t09g06.control.game;

import ldts.t09g06.Game;
import ldts.t09g06.control.Controller;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.arena.Screen;

import java.io.IOException;

public class ScreenController extends Controller<Screen> {
    public ScreenController(Screen screen) {
        super(screen);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        // Handle game logic (if any) using the parent class

        // Update the viewport to follow the hero
        getModel().followHero(getModel().getHero().getPosition());

        // Additional logic specific to viewport adjustments can go here
    }
}
