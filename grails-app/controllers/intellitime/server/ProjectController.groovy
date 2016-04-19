package intellitime.server

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json

@Transactional(readOnly = true)
class ProjectController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 100, 1000)
        respond Project.list(params), model:[projectCount: Project.count()]
    }

    def show(Project project) {
        respond project
    }

    @Transactional
    def save(Project project) {
        if (project == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (project.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond project.errors, view:'create'
            return
        }

        project.save flush:true

        //json g.render(project)
        respond project, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Project project) {
        if (project == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (project.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond project.errors, view:'edit'
            return
        }

        project.save flush:true

        respond project, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Project project) {

        if (project == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        project.delete flush:true

        render status: NO_CONTENT
    }
}
