package pomodoro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DailyActivityServiceSpec extends Specification {

    DailyActivityService dailyActivityService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new DailyActivity(...).save(flush: true, failOnError: true)
        //new DailyActivity(...).save(flush: true, failOnError: true)
        //DailyActivity dailyActivity = new DailyActivity(...).save(flush: true, failOnError: true)
        //new DailyActivity(...).save(flush: true, failOnError: true)
        //new DailyActivity(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //dailyActivity.id
    }

    void "test get"() {
        setupData()

        expect:
        dailyActivityService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<DailyActivity> dailyActivityList = dailyActivityService.list(max: 2, offset: 2)

        then:
        dailyActivityList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        dailyActivityService.count() == 5
    }

    void "test delete"() {
        Long dailyActivityId = setupData()

        expect:
        dailyActivityService.count() == 5

        when:
        dailyActivityService.delete(dailyActivityId)
        sessionFactory.currentSession.flush()

        then:
        dailyActivityService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        DailyActivity dailyActivity = new DailyActivity()
        dailyActivityService.save(dailyActivity)

        then:
        dailyActivity.id != null
    }
}
