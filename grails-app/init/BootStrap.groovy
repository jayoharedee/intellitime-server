package intellitime.server

import grails.util.Environment
import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
        def result = '################## running in UNCLEAR mode.'

        println "Application starting ... "
        switch (Environment.current) {
            case Environment.DEVELOPMENT:
                result = 'now running in DEV mode.'
                //seedTestData()
                break;
            case Environment.TEST:
                result = 'now running in TEST mode.'
                break;
            case Environment.PRODUCTION:
                result = 'now running in PROD mode.'
                //seedProdData()
                break;
        }

        println "current environment: $Environment.current"
        println "$result"

        // register JSON Marshaller
        JSON.registerObjectMarshaller(Project) {
            def returnArray = [:]
            returnArray["id"] = it.id
            returnArray["name"] = it.name
            returnArray["lead"] = it.lead
            returnArray["department"] = it.department
            returnArray["projectStart"] = it.projectStart
            returnArray["projectEnd"] = it.projectEnd
            returnArray["budget"] = it.budget
            return returnArray
        }

        JSON.registerObjectMarshaller(Timesheet) {
            def returnArray = [:]
            returnArray["id"] = it.id
            returnArray["hours"] = it.hours
            returnArray["date"] = it.date
            returnArray["weekNumber"] = it.weekNumber
            returnArray["fiscalWeekNumber"] = it.fiscalWeekNumber
            returnArray["year"] = it.year
            returnArray["day"] = it.day
            returnArray["submitted"] = it.submitted
            returnArray["comment"] = it.comment
            return returnArray
        }
    }

    def destroy = {
        println "Application shutting down... "
    }

    private void seedTestData() {
        println "Loading projects into the database..."

        Project project = null
        project = new Project(
                name: 'Con Ed Search Enhancements',
                department: "Continuing Education",
                lead: 'Jordan',
                projectStart: 'Mon Apr 11 2016 09:00:00 GMT-0400 (EDT)',
                projectEnd: 'Mon Apr 19 2016 05:00:00 GMT-0400 (EDT)',
                budget: '9,000'
        )
        assert project.save(failOnError:true, flush:true, insert: true)

        project = new Project(
                name: 'Responsive Roll Out',
                department: "WPT",
                lead: 'Jordan',
                projectStart: 'Fri Apr 08 2016 08:00:00 GMT-0400 (EDT)',
                projectEnd: 'Sun Apr 17 2016 09:00:00 GMT-0400 (EDT)',
                budget: '11,000'
        )
        assert project.save(failOnError:true, flush:true, insert: true)

        assert Project.count == 2;

        println "Finished loading $Project.count projects into the database"

        // loading up some timesheets
        println "Loading projects into the database..."

        Timesheet sheet = null
        sheet = new Timesheet(
                date: 'Fri Apr 08 2016 08:00:00 GMT-0400 (EDT)',
                hours: 8,
                weekNumber: 1,
                fiscalWeekNumber: 1,
                year: 2016,
                day: 'Monday',
                submitted: false,
                comment: 'Created method for USB-based labels from Destiny'
        )
        assert sheet.save(failOnError:true, flush:true, insert: true)

        sheet = new Timesheet(
                date: 'Fri Apr 08 2016 08:00:00 GMT-0400 (EDT)',
                hours: 8,
                weekNumber: 1,
                fiscalWeekNumber: 1,
                year: 2016,
                day: 'Tuesday',
                submitted: false,
                comment: 'Created method for USB-based labels from Destiny'
        )
        assert sheet.save(failOnError:true, flush:true, insert: true)

        assert Timesheet.count == 2;

        println "Finished loading $Timesheet.count timesheets into the database"
    }


}
