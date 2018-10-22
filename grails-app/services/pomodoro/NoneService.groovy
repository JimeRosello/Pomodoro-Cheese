package pomodoro

import grails.gorm.services.Service

@Service(None)
interface NoneService {

    None get(Serializable id)

    List<None> list(Map args)

    Long count()

    void delete(Serializable id)

    None save(None none)

}