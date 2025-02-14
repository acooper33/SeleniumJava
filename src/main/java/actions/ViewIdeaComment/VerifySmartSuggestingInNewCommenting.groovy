package actions.ViewIdeaComment;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*

class VerifySmartSuggestingInNewCommenting{
    public void run(def params){
        
        def verify = [:] 
        def path = "//*[contains(@class,'f-comment-input-memberlist-name') and normalize-space(text())='${params."User"}']"
        verify.ID = "${path}"
        verify.IDChildren = []
        if(params."User Image"!=null){
            def img
            if(params."User Image"){img = "./..//IMG[contains(@src,'/ct/getfile.php')]"}
            else {img = "./..//*[@class='member-initial']"}
            verify.IDChildren << "${img}"
        }
        if(params."Placement Number") {
            verify.ID= "//*[contains(@class,'f-comment-input-member')][${params."Placement Number"}]${path}"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
        if(params."Click on the User"==true){
            Click.run(verify)
        }
    }
}