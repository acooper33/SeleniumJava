package actions.ViewIdea30;

import screens.ViewIdea30Locators
import screens.WhiteboardLocators
import actions.selenium.Click
import actions.selenium.WaitForElement
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import actions.selenium.Exists

class TeamWorkspaceOnVI3{
    public void run(def params){
        
        if(params."Click Button"=="Create") {
            Click.run("ID Type":"By", By:ViewIdea30Locators.createTeamWorkspaceButton) 
            WaitForElement.run(ID: "//*[@class='idea-options'][.='Go to Submission']", "Timeout In Seconds":"20")
            assert Exists.run(ID: "//*[@class='idea-options'][.='Go to Submission']")==1, "Error - Team Workspace Failed To Load"
        }
        else if(params."Click Button"=="Open") {	
            Click.run("ID Type":"By",By:ViewIdea30Locators.teamWorkspaceButton)
            WaitForElement.run(ID: "//*[@class='idea-options'][.='Go to Submission']", "Timeout In Seconds":"20")
            assert Exists.run(ID: "//*[@class='idea-options'][.='Go to Submission']")==1, "Error - Team Workspace Failed To Load"

        }
    }
}