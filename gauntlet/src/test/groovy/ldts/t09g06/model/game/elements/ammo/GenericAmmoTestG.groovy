package ldts.t09g06.model.game.elements.ammo

import spock.lang.Specification

class GenericAmmoTestG extends Specification{
    def "GenericAmmo should instatiate correct values"() {
        given:
            def ammo = new Bullet(10, 10, 'c' as char, 1, 0)
        expect:
            ammo.getDx() == 1
            ammo.getDy() == 0
            ammo.getPosition().getX() == 10
            ammo.getPosition().getY() == 10
            ammo.getElement() == 'c' as char

    }

}
