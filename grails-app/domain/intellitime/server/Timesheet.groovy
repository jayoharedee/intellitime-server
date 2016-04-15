package intellitime.server

class Timesheet {

    String date
    String day
    String comment
    int weekNumber
    int fiscalWeekNumber
    int year
    float hours
    boolean submitted

    static belongsTo = [
            projects:Project,
            activities:Activity,
            appUsers:AppUser
    ]

    static constraints = {
        date nullable: true
        day nullable: true
        weekNumber nullable: true
        fiscalWeekNumber nullable: true
        year nullable: true
        hours nullable: true
        submitted nullable: true
        comment nullable: true
    }
}
