package actions.general;

import actions.selenium.Browser
import actions.selenium.Click
import actions.selenium.Exists

class ClickonElementandVerifyElementexistsinotherTab{
    public void run(def params){
        if(!params."Tab (optional)"){params."Tab (optional)"="1"}
        print("ID: ")
        println(params."XPATH of an element to click on")
        Click.run(ID:params."XPATH of an element to click on")
        sleep(2000)
        ArrayList tabs = new ArrayList (Browser.Driver.getWindowHandles())
        println("We have ${tabs.size()} tabs open")
        Browser.Driver.switchTo().window(tabs.get(params."Tab (optional)".toInteger()))
        assert Exists.run(ID:params."XPATH of element to verify")>0,"Error - Element in a new tab NOT found"
        Browser.Driver.switchTo().window(tabs.get(0))
    }
}