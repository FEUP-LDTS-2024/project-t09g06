package ldts.t09g06.view.game;

import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.game.elements.monsters.GenericMonster;

public class MonsterViewer implements ElementViewer<GenericMonster> {
    @Override
    public void draw(GenericMonster monster, GUI gui) {
        gui.drawMonster(monster.getPosition());
    }
}