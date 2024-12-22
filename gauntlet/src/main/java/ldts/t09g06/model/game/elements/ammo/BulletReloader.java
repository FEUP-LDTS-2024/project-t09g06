package ldts.t09g06.model.game.elements.ammo;

    public class BulletReloader extends Reloader{
        public BulletReloader(int x, int y, char c) {
            super(x, y, c);
            this.amount = 5;
        }
}