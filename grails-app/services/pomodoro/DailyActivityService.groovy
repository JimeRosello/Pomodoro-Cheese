package pomodoro

import grails.gorm.services.Service

@Service(DailyActivity)
interface DailyActivityService {

    DailyActivity get(Serializable id)

    List<DailyActivity> list(Map args)

    Long count()

    void delete(Serializable id)

    DailyActivity save(DailyActivity dailyActivity)

}