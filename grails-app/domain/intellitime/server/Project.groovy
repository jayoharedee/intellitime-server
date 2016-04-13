package intellitime.server

class Project {

    String name
    String lead
    String department
    String projectStart
    String projectEnd
    float budget

    static hasMany = [timesheets: Timesheet]

    static constraints = {
    }
}
