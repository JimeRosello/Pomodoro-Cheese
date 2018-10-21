package pomodoro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BoardServiceSpec extends Specification {

    BoardService boardService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Board(...).save(flush: true, failOnError: true)
        //new Board(...).save(flush: true, failOnError: true)
        //Board board = new Board(...).save(flush: true, failOnError: true)
        //new Board(...).save(flush: true, failOnError: true)
        //new Board(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //board.id
    }

    void "test get"() {
        setupData()

        expect:
        boardService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Board> boardList = boardService.list(max: 2, offset: 2)

        then:
        boardList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        boardService.count() == 5
    }

    void "test delete"() {
        Long boardId = setupData()

        expect:
        boardService.count() == 5

        when:
        boardService.delete(boardId)
        sessionFactory.currentSession.flush()

        then:
        boardService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Board board = new Board()
        boardService.save(board)

        then:
        board.id != null
    }
}
