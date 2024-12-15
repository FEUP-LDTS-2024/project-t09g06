package ldts.t09g06.model.game.elements.monsters;

public class BossMonster extends GenericMonster{
    private int life;
    public BossMonster(int x, int y, char c){
        super(x,y,c);
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
