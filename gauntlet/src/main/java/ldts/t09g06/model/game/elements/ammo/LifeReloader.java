package ldts.t09g06.model.game.elements.ammo;

import ldts.t09g06.model.game.elements.Element;

public class LifeReloader extends Element {
    private int amount_life;
    public LifeReloader(int x, int y, char c) {
        super(x, y, c);
        this.amount_life = 5;
    }


    public boolean collidesWith(Element element) {
        return getPosition().equals(element.getPosition());
    }

    public void setQuantity(int q){this.amount_life = q;}
    public int getAmount_life() {
        return amount_life;
    }
}