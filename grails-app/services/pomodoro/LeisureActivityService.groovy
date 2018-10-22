package pomodoro

import grails.gorm.services.Service

@Service(LeisureActivity)
interface LeisureActivityService {

    LeisureActivity get(Serializable id)

    List<LeisureActivity> list(Map args)

    Long count()

    void delete(Serializable id)

    LeisureActivity save(LeisureActivity leisureActivity)

}