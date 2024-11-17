package ldts.t09g06;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

    public class Hero extends Element{
        public Hero(){
            super(10,10);
        }
        public Hero(int x, int y){
            super(x,y);
        }

        public int getX() {
            return position.getX();
        }

        public int getY() {
            return position.getY();
        }

        public void setX(int x) {
            this.position.setX(x);
        }
        @Override
        public void setPosition(Position position) {
            super.setPosition(position);
        }

        public void setY(int y) {
            this.position.setY(y);
        }
        public Position moveUp(){ return new Position( position.getX(), position.getY()-1);}
        public Position moveDown(){ return new Position( position.getX(), position.getY()+1);}
        public Position moveRight(){ return new Position( position.getX() +1 , position.getY());}
        public Position moveLeft(){ return new Position( position.getX()-1, position.getY());}

        @Override
        public void draw(TextGraphics graphics){
            graphics.setForegroundColor(TextColor.Factory.fromString(" #d0d3d4"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(position.getX(),position.getY()), "X");
        }
    }


