package actions.ViewIdea.BusinessImpact;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyAttachmentinBusinessImpactTab{
    public void run(def params){
        
         //Map all values that will be used for verification for that instance
        def verify = [:]
        verify.ID= "//*[@class='tab-body ${params."Section".toLowerCase()}-impact']//A[text()='${params."Attachment File"}']"     
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}

        VerifyNumberOfMatches.run(verify)
    }
}