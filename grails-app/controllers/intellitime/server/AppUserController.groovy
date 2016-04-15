package intellitime.server

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AppUserController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond AppUser.list(params), model:[appUserCount: AppUser.count()]
    }

    def show(AppUser appUser) {
        respond appUser
    }

    @Transactional
    def save(AppUser appUser) {
        if (appUser == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (appUser.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond appUser.errors, view:'create'
            return
        }
        println(appUser.properties)

        appUser.save flush:true

        respond appUser, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(AppUser appUser) {
        if (appUser == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (appUser.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond appUser.errors, view:'edit'
            return
        }

        appUser.save flush:true

        respond appUser, [status: OK, view:"show"]
    }

    @Transactional
    def delete(AppUser appUser) {

        if (appUser == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        appUser.delete flush:true

        render status: NO_CONTENT
    }
}
