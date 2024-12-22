package ldts.t09g06.model;

public class Constants {

    // COLORS
    public static final String WHITE = "#FFFFFF";
    public static final String BLACK = "#000000";
    public static final String COLOR_MENU = "#0A3981";
    public static final String RED_ = "#0A97B0";
    public static final String RED = "#FF0000";
    public static final String GREEN = "#008000";

    public static final String LIGHTGREY = "#D3D3D3";

    public static final String LIGHTBLUE = "#ADD8E6";

    public static final String YELLOW = "#FFD700";

    //MENU

    public static final String MENU = "MENU";
    public static final int menuHeight = 40;
    public static final int menuWidth = 80;


    public static int WIDTH;
    public static int HEIGHT;

    public static void setDimensions(int level) {
        switch(level){
            case 0, 1, 2:
                Constants.HEIGHT = HEIGHT1;
                Constants.WIDTH = WIDTH1;
                break;
            case 3:
                Constants.HEIGHT = HEIGHT4;
                Constants.WIDTH = WIDTH4;
                break;
            case 4:
                Constants.HEIGHT = HEIGHT5;
                Constants.WIDTH = WIDTH5;
                break;
        }

    }

    //GAME SCREEN
    public static final int WIDTH1 = 100;
    public static final int HEIGHT1 = 50;
    public static final int WIDTH4= 20;
    public static final int HEIGHT4 = 200;
    public static final int WIDTH5= 20;
    public static final int HEIGHT5 = 20;

    //radius around player
    public static int VIEW_SIZE_X = 320;
    public static int VIEW_SIZE_Y = 160;

    // LEADERBOARD
    public static final int maxNameLength = 10;

    //SPRITES
    public static final int SPRITE_SIZE = 16;
}
