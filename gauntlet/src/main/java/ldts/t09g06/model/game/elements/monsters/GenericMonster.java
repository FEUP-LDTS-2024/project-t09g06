package ldts.t09g06.model.game.elements.monsters;

import ldts.t09g06.model.Position;
import ldts.t09g06.model.game.elements.Element;

public abstract class GenericMonster extends Element {
    protected Position heroPosition;
    public GenericMonster(int x, int y, char c) {
        super(x, y, c);
    }
    public void setHeroPosition(Position p){
        this.heroPosition = p;
    }
    public Position getHeroPosition(){
        return heroPosition;
    }
}
