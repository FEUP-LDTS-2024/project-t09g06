package ldts.t09g06.model.game.elements.heroes;

import ldts.t09g06.model.game.elements.Element;

import static ldts.t09g06.model.game.elements.Constants.RED;

public class Hero extends Element {
    public Hero(int x,int y){super(x,y);}
    @Override
    public String getCharacter() {
        return "X";
    }
    @Override
    public String getColor() {
        return RED;
    }
}
