package pomodoro

import grails.gorm.services.Service

@Service(DailyTracker)
interface DailyTrackerService {

    DailyTracker get(Serializable id)

    List<DailyTracker> list(Map args)

    Long count()

    void delete(Serializable id)

    DailyTracker save(DailyTracker dailyTracker)

}
