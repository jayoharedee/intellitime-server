package intellitime.server

class Activity {

    String activityName

    static hasMany = [timesheets:Timesheet]

    static constraints = {
    }
}
