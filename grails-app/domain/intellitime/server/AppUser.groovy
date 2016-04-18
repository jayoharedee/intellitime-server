package intellitime.server

class AppUser {

    String fullName
    String userName
    String email
    String password
    String title

    static hasMany = [
            timesheets:Timesheet,
            budgets:ProjectBudget
    ]

    static constraints = {
        title nullable: true
    }
}
