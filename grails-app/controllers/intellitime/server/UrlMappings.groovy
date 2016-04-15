package intellitime.server

class UrlMappings {

    static mappings = {
        /*"/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }*/

        // #### PROJECTS ####
        // GET ALL OR ONE
        "/projects"(controller: "project", action: "index", method: "GET")
        "/projects/$id"(controller: "project", action: "show", method: "GET")

        // POST METHODS
        "/projects"(controller: "project", action: "save", method: "POST")

        // THE REST OF HTTP
        "/projects/$id?"(controller: "project", action: "save", method: "OPTIONS")
        "/projects/$id?"(controller: "project", action: "update", method: "PUT")
        "/projects/$id"(controller: "project", action: "delete", method: "DELETE")


        // #### TIMESHEETS ####
        // GET ALL OR ONE
        "/sheets"(controller: "timesheet", action: "index", method: "GET")
        "/sheets/$id"(controller: "timesheet", action: "show", method: "GET")

        // POST
        "/sheets"(controller: "timesheet", action: "save", method: "POST")

        // THE REST OF HTTP
        "/sheets/$id"(controller: "timesheet", action: "update", method: "PUT")
        "/sheets/$id"(controller: "timesheet", action: "delete", method: "DELETE")


        // #### ACTIVITIES ####
        // GET ALL OR ONE
        "/activities"(controller: "activity", action: "index", method: "GET")
        "/activities/$id"(controller: "activity", action: "show", method: "GET")

        // POST
        "/activities"(controller: "activity", action: "save", method: "POST")

        // THE REST OF HTTP
        "/activities/$id"(controller: "activity", action: "update", method: "PUT")
        "/activities/$id"(controller: "activity", action: "delete", method: "DELETE")

        // #### USERS ####
        // GET ALL OR ONE
        "/users"(controller: "appUser", action: "index", method: "GET")
        "/users/$id"(controller: "appUser", action: "show", method: "GET")

        // POST
        "/users"(controller: "appUser", action: "save", method: "POST")

        // OTHER HTTP METHODS
        "/users/$id?"(controller: "appUser", action: "save", method: "OPTIONS")
        "/users/$id"(controller: "appUser", action: "update", method: "PUT")
        "/users/$id"(controller: "appUser", action: "delete", method: "DELETE")


        // #### BUDGETS ####
        // GET ALL OR ONE
        "/budgets"(controller: "projectBudget", action: "index", method: "GET")
        "/budgets/$id?"(controller: "projectBudget", action: "show", method: "GET")

        // POST
        "/budgets"(controller: "projectBudget", action: "save", method: "POST")

        // OTHER HTTP METHODS
        "/budgets/$id?"(controller: "projectBudget", action: "save", method: "OPTIONS")
        "/budgets/$id"(controller: "projectBudget", action: "update", method: "PUT")
        "/budgets/$id"(controller: "projectBudget", action: "delete", method: "DELETE")




        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
