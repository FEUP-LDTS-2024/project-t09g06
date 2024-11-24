package ldts.t09g06.model.game.elements.heroes

import ldts.t09g06.model.Direction
import spock.lang.Specification

import  ldts.t09g06.model.Direction


class HeroTestG extends Specification{

    def hero = new Hero(10, 10, 'H' as char)

    def "Hero should have initial life, ammo and direction set correctly"() {
        expect:
            hero.getLife() == 5
            hero.getAmmo() == 5
            hero.getDirection() == Direction.RIGHT
    }

    def "Hero life should decrease correctly"() {
        when:
            hero.decreaseLife(1)
        then:
            hero.getLife() == 4
    }

    def "Hero life should increase correctly"() {
        when:
            hero.increaseLife(2)
        then:
            hero.getLife() == 7
    }
    def "Hero should decrease ammo correctly"() {
        when:
            hero.decreaseAmmo()
        then:
            hero.getAmmo() == 4
    }

    def "Hero should increase ammo correctly"() {
        when:
            hero.increaseAmmo(1)
        then:
            hero.getAmmo() == 6
    }

    def "Hero should shoot correctly if ammo is available"() {
        when:
            hero.shoot()
        then:
            hero.getAmmo() == 4
    }

    def "Hero should not shoot if ammo is 0"() {
        hero.decreaseAmmo()
        hero.decreaseAmmo()
        hero.decreaseAmmo()
        hero.decreaseAmmo()
        hero.decreaseAmmo()
        when:
            hero.shoot()
        then:
            hero.getAmmo() == 0
    }

    def "Hero direction should be set and retrieved correctly"() {
        when:
            hero.setDirection(Direction.UP)
        then:
            hero.getDirection() == Direction.UP
    }
    
}
