package intellitime.server

class ProjectBudget {

    String hours
    int fiscalYear

    static belongsTo = [project:Project, appUser:AppUser]

    static constraints = {
        project nullable: true
        appUser nullable: true
    }
}
