package ldts.t09g06.model.game.elements.ammo;

import ldts.t09g06.model.game.elements.Element;

public abstract class Reloader extends Element{
    protected int amount;
    public Reloader(int x, int y, char c) {
        super(x, y, c);
        this.amount = 5;
    }
    public boolean collidesWith(Element element) {
        return getPosition().equals(element.getPosition());
    }

    public void setQuantity(int q){this.amount = q;}
    public int getAmount() {
        return amount;
    }
}
