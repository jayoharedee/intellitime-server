package intellitime.server

class Project {

    String name
    String lead
    String department
    String projectStart
    String projectEnd
    float budget

    static hasMany = [
            timesheets:Timesheet,
            budgets:ProjectBudget
    ]

    static constraints = {
        department nullable: true
        projectStart nullable: true
        projectEnd nullable: true
        budget nullable: true
        lead nullable: true
        name nullable: true
    }
}
