package myloggingcontroller

import grails.testing.web.controllers.ControllerUnitTest
import org.slf4j.Logger
import spock.lang.Shared
import spock.lang.Specification
import uk.org.lidalia.slf4jext.Level
import uk.org.lidalia.slf4jtest.TestLoggerFactory

class LoggingControllerSpec extends Specification implements ControllerUnitTest<LoggingController> {

    @Shared
    def logger = TestLoggerFactory.getTestLogger(LoggingController)

    def cleanup() {
        TestLoggerFactory.clear()
    }

    void "index action writes to logs"() {
        when:
        controller.index()

        then:
        logger.loggingEvents.size() == 1
        logger.loggingEvents[0].level == Level.ERROR
    }

}
