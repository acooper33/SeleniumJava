package actions.ViewIdeaComment;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.MouseOver
import actions.selenium.Browser
import actions.selenium.utils.Elements

class VerifyAttachmentforCommentinViewIdeaandNGAViewIdea{
    public void run(def params){

        //Map all values that will be used for verification for that instance
        def path = "//*[@data-test='f-test-comment-wrapper']/*[contains(.,'${params."Comment"}')]"
        def verify = [:]
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        verify.ID= "${path}//*[text()='${params."Attachment File"}']"    
        VerifyNumberOfMatches.run(verify)
    }
}