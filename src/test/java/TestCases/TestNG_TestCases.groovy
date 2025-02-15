package TestCases

import BaseClasses.TestBase
import actions.selenium.Browser
import org.junit.Assert
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.testng.annotations.Test

class TestNG_TestCases extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(TestNG_TestCases.class);

    @Test
    public void testcaseFail() {
        logger.info("1This is an info message");
        logger.debug("1This is a debug message");
        logger.error("1This is an error message");
        Assert.assertEquals("One", "Two");
    }

    @Test
    public void testcasePass(){
        logger.info("2This is an info message");
        logger.debug("2This is a debug message");
        logger.error("2his is an error message");
        Assert.assertEquals("One", "One");

    }

}
