package pomodoro

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class NoneController {

    NoneService noneService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond noneService.list(params), model:[noneCount: noneService.count()]
    }

    def show(Long id) {
        respond noneService.get(id)
    }

    def create() {
        respond new None(params)
    }

    def save(None none) {
        if (none == null) {
            notFound()
            return
        }

        try {
            noneService.save(none)
        } catch (ValidationException e) {
            respond none.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'none.label', default: 'None'), none.id])
                redirect none
            }
            '*' { respond none, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond noneService.get(id)
    }

    def update(None none) {
        if (none == null) {
            notFound()
            return
        }

        try {
            noneService.save(none)
        } catch (ValidationException e) {
            respond none.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'none.label', default: 'None'), none.id])
                redirect none
            }
            '*'{ respond none, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        noneService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'none.label', default: 'None'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'none.label', default: 'None'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
