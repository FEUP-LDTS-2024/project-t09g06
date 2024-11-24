package ldts.t09g06.control.game

import ldts.t09g06.Game
import ldts.t09g06.gui.GUI
import ldts.t09g06.model.game.elements.Wall
import ldts.t09g06.model.game.elements.heroes.Hero
import ldts.t09g06.model.game.elements.monsters.GenericMonster
import spock.lang.Specification
import ldts.t09g06.model.Position
import ldts.t09g06.model.game.elements.ammo.GenericAmmo
import ldts.t09g06.model.game.arena.Arena

class AmmoControllerTestG extends Specification{
    def arena = Mock(Arena)
    def ammo = Mock(GenericAmmo)
    def wall = Mock(Wall)
    def monster = Mock(GenericMonster)
    def ammoController = new AmmoController(arena)
    def game = Mock(Game)

    def setup() {
        ammoController = Spy(AmmoController)
        ammoController.getModel() >> arena
        arena.getBullets() >> [ammo]
        arena.getMonsters() >> [monster]
        arena.getWalls() >> [wall]
    }

    def "Bullet moves - Should update position"() {
        given:
            def initialPosition = new Position(5, 5)
            def nextPosition = new Position(6, 5)
            ammo.getPosition() >> initialPosition
            ammo.getDx() >> 1
            ammo.getDy() >> 0
        when:
            ammoController.step(game, GUI.ACTION.NONE,1000)
        then:
            1 * ammo.setPosition(nextPosition)
            0 * arena.removeBullets(_)
            0 * arena.removeMonsters(_)
    }

    def "Bullet collides with wall - Should be removed"() {
        given:
            def position = Mock(Position)
            ammo.getPosition() >> position
            ammo.collidesWith(wall) >> true
            arena.getBullets() >> [ammo]
            arena.getWalls() >> [wall]

        when:
            ammoController.step(game, GUI.ACTION.NONE,1000)


        then:
            1 * arena.removeBullets([ammo]) // Bullet should be removed
            0 * ammo.setPosition(_) // Bullet shouldn't move after collision
            0 * arena.removeMonsters(_) // No monsters to remove
    }

    def "Bullet collides with monster - Should remove bullet and monster"() {
        given:
            def monsterPosition = new Position(6, 5)
            def ammoPosition = new Position(6, 5)

            ammo.getPosition() >> ammoPosition
            ammo.collidesWith(monster) >> true
            monster.getPosition() >> monsterPosition

            arena.getBullets() >> [ammo]
            arena.getMonsters() >> [monster]
        when:
            ammoController.step(game, GUI.ACTION.NONE,1000)
        then:
            1 * arena.removeBullets([ammo])
            1 * arena.removeMonsters([monster])
            0 * ammo.setPosition(_)
    }

    def "Bullet continues moving - Should not be removed if no collision"() {
        given:
            def initialPosition = new Position(5, 5)
            def nextPosition = new Position(6, 5)

            ammo.getPosition() >> initialPosition
            ammo.collidesWith(_) >> false
            ammo.getDx() >> 1
            ammo.getDy() >> 0

            arena.getBullets() >> [ammo]

        when:
            ammoController.step(game, GUI.ACTION.NONE,1000)

        then:
            1 * ammo.setPosition(nextPosition)
            0 * arena.removeBullets(_)
            0 * arena.removeMonsters(_)
    }
}
