package ldts.t09g06.model.menu;

import java.util.Arrays;

public class MenuSettings extends GenericMenu{
    public MenuSettings(){
        super();
        this.entries = Arrays.asList( "Easy", "Medium", "Hard", "Impossible");
    }
}
