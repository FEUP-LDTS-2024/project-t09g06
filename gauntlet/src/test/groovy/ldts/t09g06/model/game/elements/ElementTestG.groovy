package ldts.t09g06.model.game.elements

import ldts.t09g06.model.Position
import ldts.t09g06.model.game.elements.heroes.Hero
import spock.lang.Specification

class ElementTestG extends Specification{
    def element = new Wall(5, 10, 'W' as char)

    def "Element should initialize position and element correctly"() {
        expect:
        element.getPosition() == new Position(5, 10)
        element.getElement() == 'W'
    }

    def "Element should allow setting new position"() {
        when:
            element.setPosition(new Position(8, 12))
        then:
            element.getPosition() == new Position(8, 12)
    }

    def "Element should allow setting new char"() {
        given:
        when:
            element.setElement('F' as char)
        then:
            element.getElement() == 'F'
    }

    def "Different elements should not be equal"() {
        given:
            def element2 = new Hero(10,10, "H" as char)
        expect:
            !element.equals(element2)
    }

    def "Same elements with same attributes should be equal"() {
        given:
            def element2 = new Wall(5,10, "W" as char)
        expect:
            element.equals(element2)
    }

}
