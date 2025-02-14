package actions.ViewIdea30;

import actions.selenium.SetFocus
import actions.selenium.MouseOver
import actions.selenium.Exists
import actions.selenium.WaitForElement

class VerifyTeamSubmissiononViewIdea3{
    public void run(def params){
        String teamIcon = "//*[@class='fas fa-users f-member-icon']"
        String teamImage = "//*[@class='f-idea-image ']"
        String tooltip = "//*[contains(@class,'react-tooltip__show')]"
       
        println("Performing Mouseover TeamName to see tooltip")
        SetFocus.run(ID:teamIcon)
        
        //If tooltip is not visible, move cursor to image and back to the team name
        //This workaround is in place to deal with flyover inconsistencies on agent machines. 
        //See https://brightidea.jira.com/browse/BPD-38942 for more details
        int attempts = 4
        while(!Exists.run(ID:tooltip) && attempts >= 0){
            println("Team tooltip was not found, moving cursur and trying again. Attempt ${attempts}")
            SetFocus.run(ID:teamImage)
            SetFocus.run(ID:teamIcon)
            attempts--;
        }

        def verifyTooltip = [:]
		verifyTooltip.ID = tooltip
        assert Exists.run(ID:tooltip) == 1,"Failed to find team member tooltip after mouseover"
        assert Exists.run(ID:"//*[contains(@class,'f-team-member-tooltip')]") == 1,"Failed to find team member tooltip after mouseover"

        
        params."Team Members".split(",").eachWithIndex{ name, x ->
            if(params."Team Members Image".split(",")[x]=="TRUE"){
                assert Exists.run(ID:"//*[contains(@class,'f-team-member-tooltip')]//*[@class='f-member-name' and text()='${name}']/..//*[contains(@src,'ct/getfile.php')]") == 1,"Error - Failed to find team member ${name}"
            } else {
                assert Exists.run(ID:"//*[contains(@class,'f-team-member-tooltip')]//*[@class='f-member-name' and text()='${name}']/..//*[@class='member-initial']") == 1,"Error - Failed to find team member ${name}"
            }
        }
    }
}