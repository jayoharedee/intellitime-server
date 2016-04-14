package intellitime.server


class CorsInterceptor {

    CorsInterceptor() { matchAll() }

    boolean before() {
        header( "Access-Control-Allow-Origin", "*" )
        boolean options = ("OPTIONS" == request.method)
        if (options) {
            header( "Access-Control-Allow-Origin", "*" )
            //header( "Access-Control-Allow-Credentials", "true" )
            header( "Access-Control-Allow-Methods", "POST, OPTIONS, DELETE, PUT")
            header( "Access-Control-Allow-Headers", "accept, content-type")
            header( "Access-Control-Max-Age", "3600" )

            response.status = 200
        }
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
