package pomodoro

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LeisureActivityController {

    LeisureActivityService leisureActivityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond leisureActivityService.list(params), model:[leisureActivityCount: leisureActivityService.count()]
    }

    def show(Long id) {
        respond leisureActivityService.get(id)
    }

    def create() {
        respond new LeisureActivity(params)
    }

    def save(LeisureActivity leisureActivity) {
        if (leisureActivity == null) {
            notFound()
            return
        }

        try {
            leisureActivityService.save(leisureActivity)
        } catch (ValidationException e) {
            respond leisureActivity.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'leisureActivity.label', default: 'LeisureActivity'), leisureActivity.id])
                redirect leisureActivity
            }
            '*' { respond leisureActivity, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond leisureActivityService.get(id)
    }

    def update(LeisureActivity leisureActivity) {
        if (leisureActivity == null) {
            notFound()
            return
        }

        try {
            leisureActivityService.save(leisureActivity)
        } catch (ValidationException e) {
            respond leisureActivity.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'leisureActivity.label', default: 'LeisureActivity'), leisureActivity.id])
                redirect leisureActivity
            }
            '*'{ respond leisureActivity, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        leisureActivityService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'leisureActivity.label', default: 'LeisureActivity'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'leisureActivity.label', default: 'LeisureActivity'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
