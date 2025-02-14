package actions.ViewIdea;

import actions.common.ViewIdeaCommon
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyAttachmentinAttachmentstabforViewIdeapage{
    public void run(def params){
        ViewIdeaCommon.NavigateTab(Tab:"Attachments")

        //Map all values that will be used for verification for that instance
        def verify = [:]
        verify.IDChildren = []
        if(params."Attachment File".contains(".png") || params."Attachment File".contains(".jpg") || params."Attachment File".contains(".gif")) {
            verify.ID= "//*[@id='image-attachment-container']//*[text()='${params."Attachment File"}']"    
            if(params."Private Attachment"){verify.IDChildren << "./../..//DIV[contains(@class,'is-private')]"}
        }  
        else 
        {
            verify.ID= "//*[@id='non-image-attachment-container']//*[text()='${params."Attachment File"}']"      
        	if (params."Private Attachment"){verify.IDChildren << "./../../DIV[contains(@class,'is-private')]"}
        }  
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
		VerifyNumberOfMatches.run(verify)
    }
}