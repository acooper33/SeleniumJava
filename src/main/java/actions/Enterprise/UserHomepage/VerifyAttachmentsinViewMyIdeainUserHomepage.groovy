package actions.Enterprise.UserHomepage;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyAttachmentsinViewMyIdeainUserHomepage{
    public void run(def params){

        //Map all values that will be used for verification for that instance
        def verify = [:]
        if(params."Attachment File".contains(".png") || params."Attachment File".contains(".jpg") || params."Attachment File".contains(".gif") || params."Attachment File".contains(".jpeg")) {
            verify.ID= "//*[@class='f-images-horizontal-scroll']/*[@class='f-image-block']//*[@alt='${params."Attachment File"}']"    
        }  
        else {
            verify.ID= "//*[@class='f-images-horizontal-scroll']/*[@class='f-file-block']//*[text()='${params."Attachment File"}']"      
        }  
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)
    }
}