package pomodoro

import grails.gorm.services.Service

@Service(Pomodoro)
interface PomodoroService {

    Pomodoro get(Serializable id)

    List<Pomodoro> list(Map args)

    Long count()

    void delete(Serializable id)

    Pomodoro save(Pomodoro pomodoro)

}