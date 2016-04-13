package intellitime.server

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TimesheetController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Timesheet.list(params), model:[timesheetCount: Timesheet.count()]
    }

    def show(Timesheet timesheet) {
        respond timesheet
    }

    @Transactional
    def save(Timesheet timesheet) {
        if (timesheet == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (timesheet.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond timesheet.errors, view:'create'
            return
        }

        timesheet.save flush:true

        respond timesheet, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Timesheet timesheet) {
        if (timesheet == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (timesheet.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond timesheet.errors, view:'edit'
            return
        }

        timesheet.save flush:true

        respond timesheet, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Timesheet timesheet) {

        if (timesheet == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        timesheet.delete flush:true

        render status: NO_CONTENT
    }
}
