package ldts.t09g06.model.game.elements.ammo;

import ldts.t09g06.model.game.elements.Element;

public class LifeReloader extends Reloader {
    public LifeReloader(int x, int y, char c) {
        super(x, y, c);
        this.amount = 5;
    }
}