package ldts.t09g06.view;

public class HeroViewer implements ElementViewer<Hero>(){
    @Override
    public void draw(Chest chest, Window window) {
        window.drawChest(chest.getPosition(), chest);
}
}