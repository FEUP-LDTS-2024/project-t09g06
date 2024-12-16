package ldts.t09g06.model.game.elements.ammo;

import ldts.t09g06.model.game.elements.Element;

public class Chest extends Element {
    public Chest(int x, int y, char c) {
        super(x, y, c);
    }


    public boolean collidesWith(Element element) {
        return getPosition().equals(element.getPosition());
    }


}