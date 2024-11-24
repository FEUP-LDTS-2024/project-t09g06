package ldts.t09g06.control.game

import ldts.t09g06.model.Direction
import ldts.t09g06.model.Position
import ldts.t09g06.model.game.arena.Arena
import ldts.t09g06.model.game.elements.ammo.GenericAmmo
import ldts.t09g06.model.game.elements.heroes.Hero
import spock.lang.Specification

class HeroControllerTestG extends Specification{
    def arena = Mock(Arena)
    def hero = Mock(Hero)
    def heroController = new HeroController(arena)

    def setup(){
        heroController = Spy(heroController)
        heroController.getModel() >> arena
        heroController.getModel().getHero() >> hero
        heroController.getModel().getHero().getPosition() >> new Position(10,10)
    }

    def "Move Hero right - Should be Successfully"() {
        given:
            arena.wallCollision(new Position(10,13)) >> false
            arena.monsterCollision(new Position(10,12)) >> false
        when:
            heroController.moveHeroRight()
        then:
            1*heroController.getModel().getHero().setPosition(_)
    }

    def "Move Hero right - Should be Successfully"() {
        given:
        arena.wallCollision(new Position(11,10)) >> false
        arena.monsterCollision(new Position(11,10)) >> false
        when:
        heroController.moveHeroRight()
        then:
        1*heroController.getModel().getHero().setPosition(_)
    }
    def "Move Hero left - Should be Successfully"() {
        given:
        arena.wallCollision(new Position(9,10)) >> false
        arena.monsterCollision(new Position(9,10)) >> false
        when:
        heroController.moveHeroLeft()
        then:
        1*heroController.getModel().getHero().setPosition(_)
    }

    def "Move Hero down - Should be Successfully"() {
        given:
        arena.wallCollision(new Position(10,11)) >> false
        arena.monsterCollision(new Position(10,11)) >> false
        when:
        heroController.moveHeroDown()
        then:
        1*heroController.getModel().getHero().setPosition(_)
    }

    def "Move Hero up - Should be Successfully"() {
        given:
        arena.wallCollision(new Position(10,9)) >> false
        arena.monsterCollision(new Position(10,9)) >> false
        when:
        heroController.moveHeroUp()
        then:
        1*heroController.getModel().getHero().setPosition(_)
    }

    def "Move Hero left - Should Fail, Collision with Wall"() {
        given:
        arena.wallCollision(new Position(9,10)) >> true
        arena.monsterCollision(new Position(10,9)) >> false
        when:
        heroController.moveHeroLeft()
        then:
        0*heroController.getModel().getHero().setPosition(_)
    }

    def "Move Hero left - Should Fail, Collision with Monster"() {
        given:
        arena.wallCollision(new Position(10,10)) >> false
        arena.monsterCollision(new Position(9,10)) >> true
        when:
        heroController.moveHeroLeft()
        then:
        0*heroController.getModel().getHero().setPosition(_)
        1*heroController.getModel().getHero().decreaseLife(_)
    }

    def "Hero Fires Ammo Facing Up - Should add a bullet to the arena"() {
        given:
        heroController.getModel().getHero().getDirection() >> Direction.UP
        when:
        heroController.heroShoot()
        then:
        1 * arena.addBullet({ GenericAmmo ammo ->
            ammo.getPosition() == new Position(10, 9) &&
                    ammo.getDx() == 0 && ammo.getDy() == -1
        })
    }

}
