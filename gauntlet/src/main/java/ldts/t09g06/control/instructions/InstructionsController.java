package ldts.t09g06.control.instructions;

import ldts.t09g06.Game;
import ldts.t09g06.control.Controller;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Constants;
import ldts.t09g06.model.instructions.Instructions;
import ldts.t09g06.model.menu.Menu;
import ldts.t09g06.states.MenuState;

import java.io.IOException;

public class InstructionsController extends Controller<Instructions>{
        public InstructionsController(Instructions model) {
            super(model);
        }
        @Override
        public void step(Game game, GUI.ACTION action, long time) throws IOException {
            switch (action) {
                case QUIT:
                    game.getGui().resizeScreen(Constants.menuWidth, Constants.menuHeight);
                    game.setState(new MenuState(new Menu(), game.getSpriteLoader()));
            }

        }
    }
