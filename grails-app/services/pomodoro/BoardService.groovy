package pomodoro

import grails.gorm.services.Service

@Service(Board)
interface BoardService {

    Board get(Serializable id)

    List<Board> list(Map args)

    Long count()

    void delete(Serializable id)

    Board save(Board board)

}