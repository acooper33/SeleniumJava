package BaseClasses

import actions.selenium.Browser
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.testng.annotations.BeforeSuite
import org.testng.annotations.AfterMethod

class TestBase {
    private static def variables = [:]

    @BeforeSuite
    public void beforeState(){
        variables."URL" = /https:\/\/test.brightideatest.com/
        variables."Browser" = /Chrome/
        variables."TestRail_RunName" = null
        variables."TestRail_ExecutionName" = null
        variables."CodeEnvironment" = /Default/
        variables."Database" = null
        Browser.getInstance() // Ensure the Browser instance is created
    }
    @AfterMethod
    public void afterState(){
        Browser.quit();
    }


}