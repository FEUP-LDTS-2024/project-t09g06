package ldts.t09g06.model.game.elements.monsters;

import ldts.t09g06.model.Position;
import ldts.t09g06.model.game.elements.Element;

public abstract class GenericMonster extends Element {
    protected Position heroPosition;
    private int life;
    public GenericMonster(int x, int y, char c) {
        super(x, y, c);
    }
    public void setHeroPosition(Position p){
        this.heroPosition = p;
    }
    public Position getHeroPosition(){
        return heroPosition;
    }
    public int getLife() {
        return life;
    }
    public void decreaseLife(int damage){
        this.life-= damage;
    }
    public void increaseLife(int bonus){
        this.life += bonus;
    }
    public void setLife(int life){this.life = life;}
}
