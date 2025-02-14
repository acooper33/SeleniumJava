package actions.Enterprise.UserHomepage;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.common.SetupCommon
import org.openqa.selenium.support.ui.Select

class SetEmailforMyIdeas{
    public String run(def params){
        
        SetupCommon.NavigateTab(Tab:"Site",Section:"User Homepage")
        
        //Returns email address
        WebElement element = Elements.find(ID:"//*[@id='mail_address']",Browser.Driver)
       	WebElement host = Elements.find(ID:"//*[@id='mail_host']",Browser.Driver)
        def option = new Select(host).getFirstSelectedOption()
        String selectedLabel = option.getText()
        def email = element.getAttribute("value").toString()+"@"+selectedLabel
        println(email)
        return email
    }
}