import actions.selenium.Browser
import org.testng.annotations.BeforeSuite
import org.testng.annotations.AfterMethod
import org.testng.annotations.Test

class Adem_Debug_TestCase {
    private static def variables = [:]

    @BeforeSuite
    public void beforeState(){
        variables."URL" = /https:\/\/test.brightideatest.com/
        variables."Browser" = /Chrome/
        variables."TestRail_RunName" = null
        variables."TestRail_ExecutionName" = null
        variables."CodeEnvironment" = /Default/
        variables."Database" = null
    }
    @Test
    public void testcase(){
        Browser.getInstance() // Ensure the Browser instance is created

        //Open Browser
        //*new actions.selenium.Browser().run("Run Browser in Incognito":/FALSE/.toString(),"URL":/https:\/\/ademcooper.brightideatest.com\//.toString(),"Browser Type":/Chrome/.toString())
        new actions.selenium.Browser().run("URL":/https:\/\/ademcooper.brightideatest.com\//.toString())
        //Login
        new actions.general.Login().run("Email":/bi.adminuser1@brightidea.com/.toString(),"Password":/brightidea1/.toString(),"Verify if Logged In On Enterprise homepage":false)
        //Navigate to URL
        new actions.selenium.NavigateToURL().run("URL":/https:\/\/ademcooper.brightideatest.com\/IDEA362/.toString())
        //Wait
        new actions.general.Wait().run("Seconds":/5/.toString())
        //Set Emoji Dialog
        //new actions.general.SetEmojiDialog().run("Comment":/TestComment/.toString(),"Emoji Name":/thumbs up/.toString())
    }
    @AfterMethod
    public void afterState(){
        Browser.quit();
    }
}
import org.testng.annotations.Test
