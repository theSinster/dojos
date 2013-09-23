import spock.lang.Specification
import spock.lang.Unroll

class TallPeopleSpec extends Specification {

    TallPeople tallPeople

    def setup() {
        tallPeople = new TallPeople()
    }

    @Unroll
    def "return the tallest-of-the-shortest and the shortest-of-the-tallest"() {
        expect:
        tallPeople.getPeople(people as String[]) == result

        where:
        people                | result
        ["9 2 3", "4 8 7"]    | [4, 7]
        ["1 2", "4 5", "3 6"] | [4, 4]
        ["1 1", "1 1"]        | [1, 1]
    }
}