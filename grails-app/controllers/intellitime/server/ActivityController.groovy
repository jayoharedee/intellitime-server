package intellitime.server

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ActivityController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Activity.list(params), model:[activityCount: Activity.count()]
    }

    def show(Activity activity) {
        respond activity
    }

    @Transactional
    def save(Activity activity) {
        if (activity == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (activity.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond activity.errors, view:'create'
            return
        }

        activity.save flush:true

        respond activity, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Activity activity) {
        if (activity == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (activity.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond activity.errors, view:'edit'
            return
        }

        activity.save flush:true

        respond activity, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Activity activity) {

        if (activity == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        activity.delete flush:true

        render status: NO_CONTENT
    }
}
