package actions.ViewIdea.TeamWorkspace;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*

class VerifyUserInWorkspaceTeam{
    public void run(def params){
        
        def verify = [:]
        if(params."Number of Matches" != "0"){
            SetFocus.run(ID:"//*[@class='team-member-container'][${params."Placement Number"}]/DIV")
        }        
        if(params."Is the User Owner"==true){
            verify.ID = "//*[@class='team-member-container']//*[contains(@class,'team-owner')]/..//*[@data-test='flyover-user-link' and text()='${params."User"}']"
        } else {
            verify.ID = "//*[@class='team-member-container']//*[@data-test='flyover-user-link' and text()='${params."User"}']"
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        
        VerifyNumberOfMatches.run(verify) 
    }
}