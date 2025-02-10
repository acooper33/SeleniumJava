package actions.general;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.NavigateToURL
import actions.selenium.MouseOver
import actions.selenium.Browser
import actions.selenium.*
import actions.common.SetProfileDropdown
import actions.selenium.ExplicitWait


class Navigate{
    public static void run(def params){
        def currentURL
        //Support for Labs code environment
        if(Browser.Driver.getCurrentUrl().contains("bidev.us")){
            currentURL = "${Browser.Driver.getCurrentUrl().split("\\.")[0]}.${Browser.Driver.getCurrentUrl().split("\\.")[1]}.us"
        } else  if(Browser.Driver.getCurrentUrl().contains("eu.brightidea")){
            currentURL = "${Browser.Driver.getCurrentUrl().split("\\.")[0]}.eu.${Browser.Driver.getCurrentUrl().split("\\.")[2]}.com"
        }
        else{currentURL = "${Browser.Driver.getCurrentUrl().split("\\.")[0]}.${Browser.Driver.getCurrentUrl().split("\\.")[1]}.com"}
        println("Home URL: "+currentURL)
        //Go to 'Enterprise Home Page' page first to navigate from
        NavigateToURL.run(URL:currentURL)
        ExecuteJavascript.run(Code:"window.scrollTo(0, 0);")
        //Click.run(ID:"//*[@id='nav-bar-logo']/A[1]")
        //Now navigate to area
        switch(params."Area to Navigate to"){
            case "c_a":
            	NavigateToURL.run(URL:currentURL+"/ct/c_a.bix")
            	break
            case "c_k":
            	NavigateToURL.run(URL:currentURL+"/ct/c_k.bix")
            	break
            case "c_z":
            	NavigateToURL.run(URL:currentURL+"/ct/c_z.bix")
            	break
            case "View All Ideas Board":
            	Click.run(ID:"//*[text()='View All Ideas']")
            	break
            case "Command Center":
            	NavigateToURL.run(URL:currentURL+"/app")
            	break
            case "My Activity":
            	Click.run(ID:"//*[text()='My Activity']")
            	break
            case "Apps":
            	Click.run(ID:"//*[@id='gear-button' or @aria-label='Command Center menu']", "Type of Click":"Javascript")
                Click.run(ID:"//UL//*[text()='Products']", "Type of Click":"Javascript")
            	//Click.run(ID:"//*[@id='account-links']//LI[text()='Products']", "Type of Click":"Javascript")
            	sleep(2000)
            	break
            case "Products":
            	Click.run(ID:"//*[@id='gear-button' or @aria-label='Command Center menu']")
                Click.run(ID:"//UL//*[text()='Products']")
            	sleep(2000)
            	break
            case "Enterprise Setup":
            	Click.run(ID:"//*[@id='gear-button' or @aria-label='Command Center menu']")
                Click.run(ID:"//UL//*[text()='System Setup']")
            	//Click.run(ID:"//*[@id='account-links']//LI[text()='System Setup']")
            	break
            case "People":
            	Click.run(ID:"//*[@id='gear-button' or @aria-label='Command Center menu']")
                Click.run(ID:"//UL//*[text()='People']")
            	//Click.run(ID:"//*[@id='account-links']//LI[text()='People']")
            	break
            case "Profile":
            	/*Click.run(ID:"//DIV[@id='account-dropdown']")
                sleep(2000)
            	Click.run(ID:"//DIV[@id='profile-dropdown-content']//A[.='Profile']")*/
            	SetProfileDropdown.SetProfileDropdownOption(Tab:"Profile")
            	break
            case "Blog":
            	NavigateToURL.run(URL:currentURL+"/ct/c_blog_list.bix")
            	break
            case "Action Items":
            	Navigate.run("Area to Navigate to":"Command Center")
             	Click.run(ID:"//*[@id='global-nav-bar']//*[contains(@class,'f-btn-link')]//*[contains(@class,'fa-clock')]") 
            	Click.run(ID:"//*[@class='f-item-footer'and text()='View All']")
            	sleep(1000)
            	break
            case "Action Items Manager":
            	Navigate.run("Area to Navigate to":"Command Center")
            	Click.run(ID:"//*[@id='global-nav-bar']//*[contains(@class,'f-btn-link')]//*[contains(@class,'fa-clock')]") 
            	Click.run(ID:"//*[@class='f-item-footer'and text()='View All']")
            	Click.run(ID:"//*[@id='action_item_switch_scope']")
            	sleep(1000)
            	break
            case "Innovations":
            	Click.run(ID:"//*[@id='gear-button' or @aria-label='Command Center menu']")
            	//Click.run(ID:"//A[contains(@href,'innovations')]/LI")
                Click.run(ID:"//A[contains(@href,'innovations')]")
            	break
             case "Analytics":
            	Click.run(ID:"//*[@id='gear-button' or @aria-label='Command Center menu']")
            	Click.run(ID:"//A[contains(@href,'analytics')]")
            	break
            case "User Homepage":
            	NavigateToURL.run(URL:currentURL+"/userhome")
                sleep(200)
            	break
        }        
    }
}