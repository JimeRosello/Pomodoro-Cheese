package pomodoro

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DailyTrackerController {

    DailyTrackerService dailyTrackerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond dailyTrackerService.list(params), model:[dailyTrackerCount: dailyTrackerService.count()]
    }

    def show(Long id) {
        respond dailyTrackerService.get(id)
    }

    def create() {
        respond new DailyTracker(params)
    }

    def save(DailyTracker dailyTracker) {
        if (dailyTracker == null) {
            notFound()
            return
        }

        try {
            dailyTrackerService.save(dailyTracker)
        } catch (ValidationException e) {
            respond dailyTracker.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dailyTracker.label', default: 'DailyTracker'), dailyTracker.id])
                redirect dailyTracker
            }
            '*' { respond dailyTracker, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond dailyTrackerService.get(id)
    }

    def update(DailyTracker dailyTracker) {
        if (dailyTracker == null) {
            notFound()
            return
        }

        try {
            dailyTrackerService.save(dailyTracker)
        } catch (ValidationException e) {
            respond dailyTracker.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'dailyTracker.label', default: 'DailyTracker'), dailyTracker.id])
                redirect dailyTracker
            }
            '*'{ respond dailyTracker, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        dailyTrackerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'dailyTracker.label', default: 'DailyTracker'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dailyTracker.label', default: 'DailyTracker'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
