package ldts.t09g06.view.game;

import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.game.elements.heroes.Hero;

public class HeroViewer implements ElementViewer<Hero> {
    @Override
    public void draw(Hero hero, GUI gui) {
        gui.drawHero(hero.getPosition());
    }
}
