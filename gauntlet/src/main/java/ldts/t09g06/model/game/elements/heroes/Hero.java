package ldts.t09g06.model.game.elements.heroes;

import ldts.t09g06.model.Direction;
import ldts.t09g06.model.game.elements.Element;

public class Hero extends Element {

    private int life;
    private int ammo;
    private int score = 0;
    private Direction direction;

    public int getScore() {
        return score;
    }

    public void increase_score(int num){
        score+=num;
    }

    public Hero(int x, int y, char c){
        super(x,y,c);
        this.direction = Direction.RIGHT;
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

    public int getAmmo() {
        return ammo;
    }
    public void decreaseAmmo(){
        ammo-=1;
    }
    public void increaseAmmo(int x){
        ammo += 1;
    }

    public void setAmmo_and_life(int quant, int life){
        this.ammo = quant;
        this.life = life;
    }
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
