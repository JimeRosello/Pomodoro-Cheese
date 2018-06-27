package pomodoro

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
        "/board"(view:"/board")
        "/start"(view:"/start")
        "/createTask"(view:"/task/create")
    }
}
