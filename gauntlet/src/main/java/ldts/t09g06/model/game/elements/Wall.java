package ldts.t09g06.model.game.elements;

import static ldts.t09g06.model.game.elements.Constants.BLACK;

public class Wall extends Element {
    public Wall(int x,int y){super(x,y);}
    @Override
    public String getCharacter() {
        return "W";
    }
    @Override
    public String getColor() {
        return BLACK;
    }
}