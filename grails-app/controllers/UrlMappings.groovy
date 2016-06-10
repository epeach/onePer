class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"timedWord/start")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
