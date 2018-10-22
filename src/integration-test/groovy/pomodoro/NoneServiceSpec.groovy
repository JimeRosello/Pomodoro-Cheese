package pomodoro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class NoneServiceSpec extends Specification {

    NoneService noneService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new None(...).save(flush: true, failOnError: true)
        //new None(...).save(flush: true, failOnError: true)
        //None none = new None(...).save(flush: true, failOnError: true)
        //new None(...).save(flush: true, failOnError: true)
        //new None(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //none.id
    }

    void "test get"() {
        setupData()

        expect:
        noneService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<None> noneList = noneService.list(max: 2, offset: 2)

        then:
        noneList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        noneService.count() == 5
    }

    void "test delete"() {
        Long noneId = setupData()

        expect:
        noneService.count() == 5

        when:
        noneService.delete(noneId)
        sessionFactory.currentSession.flush()

        then:
        noneService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        None none = new None()
        noneService.save(none)

        then:
        none.id != null
    }
}
