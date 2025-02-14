package actions.ProjectRoom;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*

class VerifyProjectRoomMemberinMembersTab{
    public void run(def params){
        
        def verify = [:]
        if(params."Placement Number") {verify.ID = "//*[contains(@class,'f-member-row')][${params."Placement Number"}]//*[@class='f-member']//*[text()='${params."Member Name"}']"}
        else {verify.ID = "//*[contains(@class,'f-member-row')]//*[@class='f-member']//*[text()='${params."Member Name"}']"}
          
        verify.IDChildren = []
        if(params."Member Display Picture"){
            if(params."Member Display Picture"==true){
                verify.IDChildren << "./../..//*[@class='member-img']"
            } else {
                verify.IDChildren << "./../..//*[@class='member-initial']"}
        }
        
        if(params."Type of Member"){verify.IDChildren << "./../..//*[contains(@class,'f-dropdown-btn') or contains(@class,'f-member-no-readonly')]//*[text()='${params."Type of Member"}']"}    	
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)
    }
}