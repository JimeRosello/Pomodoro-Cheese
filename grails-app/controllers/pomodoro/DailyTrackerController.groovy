package pomodoro

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DailyTrackerController {

    DailyActivityService dailyActivityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond dailyActivityService.list(params), model:[dailyActivityCount: dailyActivityService.count()]
    }

    def show(Long id) {
        respond dailyActivityService.get(id)
    }

    def create() {
        respond new DailyActivity(params)
    }

    def save(DailyActivity dailyActivity) {
        if (dailyActivity == null) {
            notFound()
            return
        }

        try {
            dailyActivityService.save(dailyActivity)
        } catch (ValidationException e) {
            respond dailyActivity.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dailyActivity.label', default: 'DailyActivity'), dailyActivity.id])
                redirect dailyActivity
            }
            '*' { respond dailyActivity, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond dailyActivityService.get(id)
    }

    def update(DailyActivity dailyActivity) {
        if (dailyActivity == null) {
            notFound()
            return
        }

        try {
            dailyActivityService.save(dailyActivity)
        } catch (ValidationException e) {
            respond dailyActivity.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'dailyActivity.label', default: 'DailyActivity'), dailyActivity.id])
                redirect dailyActivity
            }
            '*'{ respond dailyActivity, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        dailyActivityService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'dailyActivity.label', default: 'DailyActivity'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dailyActivity.label', default: 'DailyActivity'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
