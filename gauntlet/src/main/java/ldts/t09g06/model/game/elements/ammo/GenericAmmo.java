package ldts.t09g06.model.game.elements.ammo;

import ldts.t09g06.model.Position;
import ldts.t09g06.model.game.elements.Element;

public abstract class GenericAmmo extends Element {
    private final int dx,dy;
    private boolean isFromBoss;
    public GenericAmmo(int x, int y, char c, int dx, int dy, boolean isFromBoss) {
        super(x, y, c);
        this.dx = dx;
        this.dy = dy;
        this.isFromBoss = isFromBoss;
    }


    public boolean collidesWith(Element element) {
        return getPosition().equals(element.getPosition());
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public boolean isFromBoss() {return isFromBoss;}
}