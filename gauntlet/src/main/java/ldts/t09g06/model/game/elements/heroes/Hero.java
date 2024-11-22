package ldts.t09g06.model.game.elements.heroes;

import ldts.t09g06.model.game.elements.Element;

import static ldts.t09g06.model.game.elements.Constants.RED;

public class Hero extends Element {
    public Hero(int x,int y){super(x,y); this.life = 200;}
    private int life;
    public int getLife() {
        return life;
    }

    public void decreaseLife(int damage){
        this.life-= damage;
    }
    public void increaseLife(int bonus){
        this.life += bonus;
    }
}
