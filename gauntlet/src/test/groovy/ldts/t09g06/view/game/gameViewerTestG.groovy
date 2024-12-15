package ldts.t09g06.view.game

import ldts.t09g06.gui.GUI
import ldts.t09g06.gui.LanternaGUI
import ldts.t09g06.model.Position
import ldts.t09g06.model.game.arena.Arena
import ldts.t09g06.model.game.elements.Element
import ldts.t09g06.model.game.elements.Wall
import ldts.t09g06.model.game.elements.ammo.GenericAmmo
import ldts.t09g06.model.game.elements.heroes.Hero
import ldts.t09g06.model.game.elements.monsters.GenericMonster
import spock.lang.Specification

//class gameViewerTestG extends Specification {

//    def "drawModel should handle empty lists gracefully"() {
//        given:
//            def gui = Mock(GUI)
//            def arena = Mock(Arena)

//            def hero = Mock(Hero)
//            arena.getHero() >> hero
//            arena.getWalls() >> []
//            arena.getMonsters() >> []
//            arena.getBullets() >> []

//            hero.getLife() >> 5
//            hero.getAmmo() >> 10

//            def gameViewer = new GameViewer(arena)

//        when:
//            gameViewer.drawModel(gui)

//        then: "No elements are drawn for empty lists"
//            0 * gui.draw(_)

//        and: "Hero stats are still displayed"
//            1 * gui.drawText(new Position(0, 0), "Energy: 5", "#FFD700")
//            1 * gui.drawText(new Position(10, 0), "Ammo: 10", "#FFD700")
//    }
//}
