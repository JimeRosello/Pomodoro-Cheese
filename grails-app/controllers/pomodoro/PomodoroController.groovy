package pomodoro

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PomodoroController {

    PomodoroService pomodoroService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond pomodoroService.list(params), model:[pomodoroCount: pomodoroService.count()]
    }

    def show(Long id) {
        respond pomodoroService.get(id)
    }

    def create() {
        respond new Pomodoro(params)
    }

    def save(Pomodoro pomodoro) {
        if (pomodoro == null) {
            notFound()
            return
        }

        try {
            pomodoroService.save(pomodoro)
        } catch (ValidationException e) {
            respond pomodoro.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pomodoro.label', default: 'Pomodoro'), pomodoro.id])
                redirect pomodoro
            }
            '*' { respond pomodoro, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond pomodoroService.get(id)
    }

    def update(Pomodoro pomodoro) {
        if (pomodoro == null) {
            notFound()
            return
        }

        try {
            pomodoroService.save(pomodoro)
        } catch (ValidationException e) {
            respond pomodoro.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pomodoro.label', default: 'Pomodoro'), pomodoro.id])
                redirect pomodoro
            }
            '*'{ respond pomodoro, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        pomodoroService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pomodoro.label', default: 'Pomodoro'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pomodoro.label', default: 'Pomodoro'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
