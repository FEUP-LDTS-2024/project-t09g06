package ldts.t09g06.model.game.menu

import ldts.t09g06.model.menu.Menu
import spock.lang.Specification

class MenuTestG extends Specification{
    def menu = new Menu()

    def "Menu should initialize with three entries"() {
        expect:
        menu.getNumberEntries() == 3
            menu.getEntry(0) == "Start"
            menu.getEntry(1) == "Instructions"
            menu.getEntry(2) == "Exit"
    }

    def "Menu should correctly cycle through entries using nextEntry"() {
        when:
            menu.nextEntry()
        then:
            menu.isSelected(1)
        when:
            menu.nextEntry()
        then:
            menu.isSelected(2)
        when:
            menu.nextEntry()
        then:
            menu.isSelected(0)
    }

    def "Menu should correctly cycle through entries using previousEntry"() {
        when:
            menu.previousEntry()
        then:
            menu.isSelected(2)
        when:
            menu.previousEntry()
        then:
            menu.isSelected(1)
        when:
            menu.previousEntry()
        then:
            menu.isSelected(0)
    }

    def "Menu should correctly select the Start entry"() {
        expect:
            menu.isSelectedStart() == true
    }

    def "Menu should correctly select the Exit entry"() {
        given:
            menu.nextEntry()
            menu.nextEntry()
        expect:
            menu.isSelectedExit() == true
    }

    def "Menu should return the correct entry when getEntry is called"() {
        expect:
            menu.getEntry(0) == "Start"
            menu.getEntry(1) == "Instructions"
            menu.getEntry(2) == "Exit"
    }

    def "Menu should handle wrapping correctly when using nextEntry beyond the last entry"() {
        when:
            menu.nextEntry()
            menu.nextEntry()
            menu.nextEntry()
        then:
            menu.isSelected(0)
    }

    def "Menu should handle wrapping correctly when using previousEntry before the first entry"() {
        when:
            menu.previousEntry()
            menu.previousEntry()
            menu.previousEntry()
        then:
            menu.isSelected(0) 
    }
}
