package actions.ViewIdea.BusinessImpact;

import actions.common.ViewIdeaCommon
import actions.common.TeamWorkspaceCommon
import actions.selenium.Click
import actions.selenium.ExecuteJavascript
import actions.selenium.Browser
import org.openqa.selenium.Alert

class SetBusinessImpactForViewIdeaPage{
    public void run(def params){

        ExecuteJavascript.run(Code:"window.scrollTo(0, 0);")
        if(params."Access Business Impact From"){
            if(params."Access Business Impact From"=="Team Workspace"){
                TeamWorkspaceCommon.NavigateTab(Tab:"Business Impact")
            } else {
                ViewIdeaCommon.NavigateTab(Tab:"Business Impact")  
                sleep(2000)
            }
        }
        if(params."Add or Update") {
            sleep(2000)
            Click.run(ID:"//*[contains(@id,'business-impact-')]/SPAN[contains(text(),'${params."Add or Update"}')]")
        }

        if(params."Action"){
            if (params."Action"=="Save Version") {
                Click.run(ID:"//*[@id='business-impact-button-save']")
            } else {
                Click.run(ID:"//*[@id='business-impact-button-cancel']")
                Browser.Driver.switchTo().alert().accept()
            }
        }
        sleep(1000)
    }
}

