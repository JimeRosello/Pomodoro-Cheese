package pomodoro

import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import grails.validation.ValidationException
import spock.lang.*

class BreakControllerSpec extends Specification implements ControllerUnitTest<BreakController>, DomainUnitTest<Break> {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {
        given:
        controller.breakService = Mock(BreakService) {
            1 * list(_) >> []
            1 * count() >> 0
        }

        when:"The index action is executed"
        controller.index()

        then:"The model is correct"
        !model.breakList
        model.breakCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
        controller.create()

        then:"The model is correctly created"
        model.break!= null
    }

    void "Test the save action with a null instance"() {
        when:"Save is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        controller.save(null)

        then:"A 404 error is returned"
        response.redirectedUrl == '/break/index'
        flash.message != null
    }

    void "Test the save action correctly persists"() {
        given:
        controller.breakService = Mock(BreakService) {
            1 * save(_ as Break)
        }

        when:"The save action is executed with a valid instance"
        response.reset()
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        populateValidParams(params)
        def break = new Break(params)
        break.id = 1

        controller.save(break)

        then:"A redirect is issued to the show action"
        response.redirectedUrl == '/break/show/1'
        controller.flash.message != null
    }

    void "Test the save action with an invalid instance"() {
        given:
        controller.breakService = Mock(BreakService) {
            1 * save(_ as Break) >> { Break break ->
                throw new ValidationException("Invalid instance", break.errors)
            }
        }

        when:"The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        def break = new Break()
        controller.save(break)

        then:"The create view is rendered again with the correct model"
        model.break != null
        view == 'create'
    }

    void "Test the show action with a null id"() {
        given:
        controller.breakService = Mock(BreakService) {
            1 * get(null) >> null
        }

        when:"The show action is executed with a null domain"
        controller.show(null)

        then:"A 404 error is returned"
        response.status == 404
    }

    void "Test the show action with a valid id"() {
        given:
        controller.breakService = Mock(BreakService) {
            1 * get(2) >> new Break()
        }

        when:"A domain instance is passed to the show action"
        controller.show(2)

        then:"A model is populated containing the domain instance"
        model.break instanceof Break
    }

    void "Test the edit action with a null id"() {
        given:
        controller.breakService = Mock(BreakService) {
            1 * get(null) >> null
        }

        when:"The show action is executed with a null domain"
        controller.edit(null)

        then:"A 404 error is returned"
        response.status == 404
    }

    void "Test the edit action with a valid id"() {
        given:
        controller.breakService = Mock(BreakService) {
            1 * get(2) >> new Break()
        }

        when:"A domain instance is passed to the show action"
        controller.edit(2)

        then:"A model is populated containing the domain instance"
        model.break instanceof Break
    }


    void "Test the update action with a null instance"() {
        when:"Save is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(null)

        then:"A 404 error is returned"
        response.redirectedUrl == '/break/index'
        flash.message != null
    }

    void "Test the update action correctly persists"() {
        given:
        controller.breakService = Mock(BreakService) {
            1 * save(_ as Break)
        }

        when:"The save action is executed with a valid instance"
        response.reset()
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        populateValidParams(params)
        def break = new Break(params)
        break.id = 1

        controller.update(break)

        then:"A redirect is issued to the show action"
        response.redirectedUrl == '/break/show/1'
        controller.flash.message != null
    }

    void "Test the update action with an invalid instance"() {
        given:
        controller.breakService = Mock(BreakService) {
            1 * save(_ as Break) >> { Break break ->
                throw new ValidationException("Invalid instance", break.errors)
            }
        }

        when:"The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(new Break())

        then:"The edit view is rendered again with the correct model"
        model.break != null
        view == 'edit'
    }

    void "Test the delete action with a null instance"() {
        when:"The delete action is called for a null instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(null)

        then:"A 404 is returned"
        response.redirectedUrl == '/break/index'
        flash.message != null
    }

    void "Test the delete action with an instance"() {
        given:
        controller.breakService = Mock(BreakService) {
            1 * delete(2)
        }

        when:"The domain instance is passed to the delete action"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(2)

        then:"The user is redirected to index"
        response.redirectedUrl == '/break/index'
        flash.message != null
    }
}






