package ldts.t09g06.model.game.elements.bullets;

import ldts.t09g06.model.game.elements.Element;

import static ldts.t09g06.model.game.elements.Constants.WHITE;

public class Bullet extends Element {
    public Bullet(int x,int y){super(x,y);}
    @Override
    public String getCharacter() {
        return "-";
    }
    @Override
    public String getColor() {
        return WHITE;
    }
}