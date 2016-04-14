package intellitime.server

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProjectBudgetController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ProjectBudget.list(params), model:[projectBudgetCount: ProjectBudget.count()]
    }

    def show(ProjectBudget projectBudget) {
        respond projectBudget
    }

    @Transactional
    def save(ProjectBudget projectBudget) {
        if (projectBudget == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (projectBudget.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond projectBudget.errors, view:'create'
            return
        }

        projectBudget.save flush:true

        respond projectBudget, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(ProjectBudget projectBudget) {
        if (projectBudget == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (projectBudget.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond projectBudget.errors, view:'edit'
            return
        }

        projectBudget.save flush:true

        respond projectBudget, [status: OK, view:"show"]
    }

    @Transactional
    def delete(ProjectBudget projectBudget) {

        if (projectBudget == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        projectBudget.delete flush:true

        render status: NO_CONTENT
    }
}
