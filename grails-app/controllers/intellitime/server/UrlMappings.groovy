package intellitime.server

class UrlMappings {

    static mappings = {
        /*"/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }*/

        // project routes
        "/projects"(controller: "project", action: "index", method: "GET")
        "/projects/$id"(controller: "project", action: "show", method: "GET")

        //"/projects/$id?"(controller: "project", action: "save", method: "OPTIONS")
        "/projects/$id?"(controller: "project", action: "update", method: "PUT")
        //"/projects/$id"(controller: "project", action: "delete", method: "DELETE")

        // timesheet routes
        "/sheets"(controller: "timesheet", action: "index", method: "GET")
        "/sheets/$id"(controller: "timesheet", action: "show", method: "GET")

        //"/sheets"(controller: "timesheet", action: "save", method: "POST")
        //"/sheets/$id"(controller: "timesheet", action: "update", method: "PUT")
        //"/sheets/$id"(controller: "timesheet", action: "delete", method: "DELETE")

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
