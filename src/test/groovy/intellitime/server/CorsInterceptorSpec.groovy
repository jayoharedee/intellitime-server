package intellitime.server


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(CorsInterceptor)
class CorsInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test cors interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"cors")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
