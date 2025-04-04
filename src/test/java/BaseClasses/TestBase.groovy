package BaseClasses

import actions.selenium.Browser
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.testng.annotations.BeforeSuite
import org.testng.annotations.AfterMethod

class TestBase {
    private static def variables = [:]
    private static def basestateDefault = [:]

    @BeforeSuite
    public void beforeState(){
        variables."URL" = /https:\/\/test.brightideatest.com/
        variables."Browser" = /Chrome/
        variables."TestRail_RunName" = null
        variables."TestRail_ExecutionName" = null
        variables."CodeEnvironment" = /Default/
        variables."Database" = null

        // Default BaseState params with no licensing model
        basestateDefault."Username Email" = null
        basestateDefault."Licensing Model" = null
        basestateDefault."Unlimited Brightidea Administrator License Type" = null
        basestateDefault."Brightidea Administrator License Type Purchased Count" = null
        basestateDefault."Unlimited Idea Box Manager License Type" = null
        basestateDefault."Idea Box Manager License Type Purchased Count" = null
        basestateDefault."Run Browser in Incognito" = null

        // Ensure the Browser instance is created
        Browser.getInstance()
    }
    @AfterMethod
    public void afterState(){
        Browser.quit();
    }


}