package actions.ViewIdeaComment;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*

class VerifyTaggedUsersInCommentsinViewandNGAViewIdea{
    public void run(def params){

        def path
        path = "//*[@data-test='f-test-comment-wrapper']//*[@data-tooltip-id='comments-tagged-user-flyover' and text()='${params."Tagged User"}']"
        if(params."Tagged User"){
            def verify = [:]
            verify.ID = "${path}/../..//*[contains(.,'${params."Comment"}')]"
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}        
            VerifyNumberOfMatches.run(verify) 
        }
        if(params."Access User from Comment"==true){
            Click.run(ID:"${path}")
        }
    }
}