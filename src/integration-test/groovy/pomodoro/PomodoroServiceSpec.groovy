package pomodoro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PomodoroServiceSpec extends Specification {

    PomodoroService pomodoroService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Pomodoro(...).save(flush: true, failOnError: true)
        //new Pomodoro(...).save(flush: true, failOnError: true)
        //Pomodoro pomodoro = new Pomodoro(...).save(flush: true, failOnError: true)
        //new Pomodoro(...).save(flush: true, failOnError: true)
        //new Pomodoro(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //pomodoro.id
    }

    void "test get"() {
        setupData()

        expect:
        pomodoroService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Pomodoro> pomodoroList = pomodoroService.list(max: 2, offset: 2)

        then:
        pomodoroList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        pomodoroService.count() == 5
    }

    void "test delete"() {
        Long pomodoroId = setupData()

        expect:
        pomodoroService.count() == 5

        when:
        pomodoroService.delete(pomodoroId)
        sessionFactory.currentSession.flush()

        then:
        pomodoroService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Pomodoro pomodoro = new Pomodoro()
        pomodoroService.save(pomodoro)

        then:
        pomodoro.id != null
    }
}
