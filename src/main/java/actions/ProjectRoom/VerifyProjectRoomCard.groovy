package actions.ProjectRoom;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*

class VerifyProjectRoomCard{
    public void run(def params){
        
        def verify = [:]
        verify.ID = "//*[contains(@class,'f-project-card f-userhomepage-card f-pr-card')]//*[@class='f-card-title' and text()='${params."Title"}']"
        verify.IDChildren = []
        if(params."Color of the Project Room Icon"){verify.IDChildren << "./../*[contains(@class,'f-room-color') and contains(@style,'${params."Color of the Project Room Icon"}')]"}
        if(params."Updated"){verify.IDChildren << "./../..//*[@class='f-activity' and contains(.,'${params."Updated"}')]"}
        if(params."Updated By"){verify.IDChildren << "./../..//*[@class='f-activity']//A[text()='${params."Updated By"}']"}
        if(params."Member count"){verify.IDChildren << "./../..//*[@class='f-pr-stats']//*[contains(@class,'f-pr-members')]//*[text()='${params."Member count"}']"}
        if(params."Total Objects"){verify.IDChildren << "./../..//*[@class='f-pr-stats']//*[contains(@class,'f-pr-items')]//*[text()='${params."Total Objects"}']"}
        if(params."Total Tasks"){verify.IDChildren << "./../..//*[@class='f-pr-stats']//*[contains(@class,'f-pr-tasks')]//*[text()='${params."Total Tasks"}']"}
        if(params."Placement Number") {
            verify.ID="//*[contains(@class,'f-project-card f-userhomepage-card f-pr-card')][${params."Placement Number"}]//*[contains(@class,'f-card-title') and text()='${params."Title"}']"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
        if(params."Access Project Room"==true){
            Click.run(ID:verify.ID)
        }
    }
}
  