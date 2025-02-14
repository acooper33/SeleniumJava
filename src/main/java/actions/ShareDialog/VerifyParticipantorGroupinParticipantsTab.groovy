package actions.ShareDialog;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyParticipantorGroupinParticipantsTab{
    public void run(def params){
        def verify = [:]
        def path
        if(params."User or Group"=="Group"){
          path = "//*[@class='f-member']//*[.='${params."User or GroupName"}']"    
        } else {
          path = "//*[@class='f-member' and text()='${params."User or GroupName"}']"  
        }      
        verify.ID = "${path}"
        verify.IDChildren = []
        if(params."Participant Image"!=null){
            def img
            if(params."Participant Image"){img = "./..//IMG[contains(@src,'/ct/getfile.php')]"}
            else {img = ".//*[@class='member-initial']"}
            verify.IDChildren << "${img}"
        }
        if(params."Type of User"){verify.IDChildren << "./..//*[@class='f-member-admin-text' and text()='${params."Type of User"}']"}
        if(params."Placement Number") {
            verify.ID= "//*[@class='f-member-row'][${params."Placement Number"}]${path}"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
    }
}