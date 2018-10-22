package pomodoro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BreakServiceSpec extends Specification {

    BreakService breakService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Break(...).save(flush: true, failOnError: true)
        //new Break(...).save(flush: true, failOnError: true)
        //Break break = new Break(...).save(flush: true, failOnError: true)
        //new Break(...).save(flush: true, failOnError: true)
        //new Break(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //break.id
    }

    void "test get"() {
        setupData()

        expect:
        breakService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Break> breakList = breakService.list(max: 2, offset: 2)

        then:
        breakList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        breakService.count() == 5
    }

    void "test delete"() {
        Long breakId = setupData()

        expect:
        breakService.count() == 5

        when:
        breakService.delete(breakId)
        sessionFactory.currentSession.flush()

        then:
        breakService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Break break = new Break()
        breakService.save(break)

        then:
        break.id != null
    }
}
