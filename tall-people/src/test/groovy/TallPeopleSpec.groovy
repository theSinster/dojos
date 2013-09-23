import spock.lang.Specification
import spock.lang.Unroll

class TallPeopleSpec extends Specification {

    TallPeople tallPeople

    def setup() {
        tallPeople = new TallPeople()
    }

    @Unroll
    def "return the tasks which the business man chooses to execute"() {
        expect:
        tallPeople.getPeople(people as String[]) == result

        where:
        people                | result
        ["9 2 3", "4 8 7"]    | [4, 7]
        ["1 2", "4 5", "3 6"] | [4, 4]
        ["1 1", "1 1"]        | [1, 1]
    }
}