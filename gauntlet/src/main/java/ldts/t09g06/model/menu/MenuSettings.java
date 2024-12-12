package ldts.t09g06.model.menu;

import java.util.Arrays;

public class MenuSettings extends GenericMenu{
    private int current_difficulty;
    public MenuSettings(){
        super();
        this.current_difficulty = 0;
        updateEntries();
    }

    public int getCurrent_difficulty() {
        return current_difficulty;
    }

    public void setCurrent_difficulty(int current_difficulty) {
        this.current_difficulty = current_difficulty;
    }
    public void updateEntries(){
        switch (current_difficulty){
            case 0:
                this.entries = Arrays.asList( "EASY *", "Medium", "Hard", "Impossible");
                break;
            case 1:
                this.entries = Arrays.asList( "Easy", "MEDIUM *", "Hard", "Impossible");
                break;
            case 2:
                this.entries = Arrays.asList( "Easy", "Medium", "HARD *", "Impossible");
                break;
            case 3:
                this.entries = Arrays.asList( "Easy", "Medium", "Hard", "IMPOSSIBLE *");
                break;
        }
    }
}
