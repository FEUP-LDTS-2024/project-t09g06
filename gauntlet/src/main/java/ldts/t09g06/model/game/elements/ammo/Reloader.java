package ldts.t09g06.model.game.elements.ammo;

import ldts.t09g06.model.game.elements.Element;

public class Reloader extends Element{
    private int amount_bullets;
    public Reloader(int x, int y, char c) {
        super(x, y, c);
        this.amount_bullets = 5;
    }


    public boolean collidesWith(Element element) {
        return getPosition().equals(element.getPosition());
    }

    public void setQuantity(int q){this.amount_bullets = q;}
    public int getAmount_bullets() {
        return amount_bullets;
    }
}
