package intellitime.server

class Timesheet {

    String date
    String day
    int weekNumber
    int fiscalWeekNumber
    int year
    float hours
    boolean submitted

    static belongsTo = Project
    static hasMany = [tasks: Task]

    static constraints = {
    }
}
