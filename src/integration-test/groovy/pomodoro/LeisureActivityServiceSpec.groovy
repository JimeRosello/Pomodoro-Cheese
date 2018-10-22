package pomodoro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class LeisureActivityServiceSpec extends Specification {

    LeisureActivityService leisureActivityService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new LeisureActivity(...).save(flush: true, failOnError: true)
        //new LeisureActivity(...).save(flush: true, failOnError: true)
        //LeisureActivity leisureActivity = new LeisureActivity(...).save(flush: true, failOnError: true)
        //new LeisureActivity(...).save(flush: true, failOnError: true)
        //new LeisureActivity(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //leisureActivity.id
    }

    void "test get"() {
        setupData()

        expect:
        leisureActivityService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<LeisureActivity> leisureActivityList = leisureActivityService.list(max: 2, offset: 2)

        then:
        leisureActivityList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        leisureActivityService.count() == 5
    }

    void "test delete"() {
        Long leisureActivityId = setupData()

        expect:
        leisureActivityService.count() == 5

        when:
        leisureActivityService.delete(leisureActivityId)
        sessionFactory.currentSession.flush()

        then:
        leisureActivityService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        LeisureActivity leisureActivity = new LeisureActivity()
        leisureActivityService.save(leisureActivity)

        then:
        leisureActivity.id != null
    }
}
