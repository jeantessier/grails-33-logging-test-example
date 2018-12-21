package myloggingcontroller

import grails.testing.web.controllers.ControllerUnitTest
import org.slf4j.Logger
import spock.lang.Specification

class LoggingControllerSpec extends Specification implements ControllerUnitTest<LoggingController> {

    def setup() {
        controller.log = Mock(Logger)
    }

    void "test something"() {
        when:
        controller.index()

        then:
        1 * controller.log.error(_)
    }

}
