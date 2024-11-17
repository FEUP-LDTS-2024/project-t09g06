package ldts.t09g06;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element{
    public Monster(int x, int y){
        super(x,y);
    }
    public Monster(Position p){
        super(p.getX(), p.getY());
    }
    public Position move() {
        Random random = new Random();
        int z = random.nextInt(4);
        Position result = null;
        switch(z){
            case 0 -> {
                result = new Position(this.getPosition().getX()-1,this.getPosition().getY());
            }
            case 1 -> {
                result = new Position(this.getPosition().getX()+1,this.getPosition().getY());
            }
            case 2 -> {
                result = new Position(this.getPosition().getX(),this.getPosition().getY()-1);
            }
            case 3 -> {
                result = new Position(this.getPosition().getX(),this.getPosition().getY()+1);
            }
        }
        return result;
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#7b241c"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(),position.getY()), "M");
    }
}
