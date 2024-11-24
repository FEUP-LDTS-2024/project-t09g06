package ldts.t09g06.control.game

import ldts.t09g06.Game
import ldts.t09g06.gui.GUI
import ldts.t09g06.model.Position
import ldts.t09g06.model.game.arena.Arena
import ldts.t09g06.model.game.elements.Wall
import ldts.t09g06.model.game.elements.ammo.GenericAmmo
import ldts.t09g06.model.game.elements.monsters.GenericMonster
import ldts.t09g06.model.game.elements.heroes.Hero
import spock.lang.Specification

class MonsterControllerTestG extends Specification{
    def arena = Mock(Arena)
    def game = Mock(Game)
    def monster = Mock(GenericMonster)
    def monsterController = new MonsterController(arena)
    def hero = Mock(Hero)
    def monsterPosition = Mock(Position)
    def heroPosition = Mock(Position)

    def setup() {
        arena.getHero() >> hero
        monster.getPosition() >> monsterPosition
        hero.getPosition() >> heroPosition
        monsterPosition.getCloserTo(_) >> new Position(10,10)
        arena.getMonsters() >> [monster]

    }


    def "Monster doesn't move if time interval is less than threshold"(){
        given:
            monsterController.setLastMovement(1000)
        when:
            monsterController.step(game, GUI.ACTION.NONE,1200)
        then:
            0*monster.setPosition(_)
    }

    def "Monster moves if time interval exceeds threshold"(){
        given:
            monsterController.setLastMovement(500)
        when:
            monsterController.step(game, GUI.ACTION.NONE,1200)
        then:
        1*monster.setPosition(_)
    }

    def "Monster doesn't move if collides with wall"(){
        given:
            monsterController.setLastMovement(500)
            arena.wallCollision(_) >> true
        when:
            monsterController.step(game, GUI.ACTION.NONE,1200)
        then:
            0*monster.setPosition(_)
    }

    def "Monster collides with hero - Should decrease hero life and not move"(){
        given:
            monsterController.setLastMovement(500)
            arena.wallCollision(_) >> false
            arena.elementsCollision(_,_) >> true
        when:
            monsterController.step(game, GUI.ACTION.NONE,1200)
        then:
            0*monster.setPosition(_)
            1*hero.decreaseLife(_)
    }

}


