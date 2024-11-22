package ldts.t09g06.model.game.elements.monsters;


import static ldts.t09g06.model.game.elements.Constants.GREEN;

public class ZombieMonster extends GenericMonster{
    public ZombieMonster(int x, int y){
        super(x,y);
    }

    @Override
    public String getCharacter() {
        return "Z";
    }

    @Override
    public String getColor() {
        return GREEN;
    }
}
