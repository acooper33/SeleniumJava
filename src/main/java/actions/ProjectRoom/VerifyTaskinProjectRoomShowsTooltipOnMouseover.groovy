package actions.ProjectRoom;

import actions.selenium.VerifyAttribute
import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.MouseOver
import actions.selenium.SetFocus
import actions.selenium.WaitForElement
import actions.selenium.utils.Elements
import actions.selenium.utils.VerifyNumberOfMatches
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions


class VerifyTaskinProjectRoomShowsTooltipOnMouseover{
    public void run(def params){
        
        def verifyTask = [:]
        verifyTask.ID = "//*[contains(@class,'fractal-input')]/*[@value=\"" + params."Task" + "\"]"
               
        // Mouse over task
        println("Performing MouseOver on element: " + verifyTask.ID)
        SetFocus.run(ID:"//*[contains(@class,'fractal-input')]/*[@value=\"" + params."Task" + "\"]/..") 
        
        // Verify tooltip is displayed
        def verifyTooltip = [:]
		verifyTooltip.ID = "//*[contains(@class,'react-tooltip__show')]"
        verifyTooltip."Number of Matches" = 1
        WaitForElement.run(ID:verifyTooltip.ID, "Timeout In Seconds":"100")
        println("Checking number of matches using: ${verifyTooltip}")
        VerifyNumberOfMatches.run(verifyTooltip)
        assert Exists.run(ID:"//*[contains(@class,'react-tooltip__show')]") == 1,"Failed to find team member tooltip after mouseover"
        assert Exists.run(ID:"//*[contains(@class,'react-tooltip__show')][contains(text()," + verifyTask.ID + ")]") == 1,"Error - Failed to find tooltip with label: " + verifyTask.ID

        // Click task to edit
        println("Performing Click to edit task to hide the tooltip")
        Click.run(ID:verifyTask.ID) 
        
        // Verify tooltip is hidden
        verifyTooltip."Number of Matches" = 0
        println("Checking number of matches using: ${verifyTooltip}")
        VerifyNumberOfMatches.run(verifyTooltip)

    }
}