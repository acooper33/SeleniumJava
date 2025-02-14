package actions.NGAViewIdea;

import actions.common.NGAViewIdeaCommon
import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class VerifyAttachmentinAttachmentstabforNGAViewIdeapage{
    public void run(def params){
        NGAViewIdeaCommon.NavigateTab(Tab:"Attachments")        
        def verify = [:]
        verify.IDChildren = []
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        if(params."Attachment File".contains(".png") || params."Attachment File".contains(".jpg")) {
            verify.ID="//*[@id='attachment-uploaded-images-region']//*[text()='${params."Attachment File"}']"
            if(params."Private Attachment"==true){
                    verify.IDChildren << "./../../*[contains(@class,'attachment-image-info-wrapper')]/DIV[contains(@title,'Private attachment')]"
                    VerifyNumberOfMatches.run(verify)
            }
            else if(params."Private Attachment"==false){
                    VerifyNumberOfMatches.run(verify)
                    //verify that none of those attachments is private
                    verify.IDChildren << "./../../*[contains(@class,'attachment-image-info-wrapper')]/DIV[contains(@title,'Private attachment')]"
                    verify."Number of Matches"=0
                    VerifyNumberOfMatches.run(verify)
            }
            else{VerifyNumberOfMatches.run(verify)}
        }
        else{
            verify.ID= "//*[@id='attachment-uploaded-files-region']//*[text()='${params."Attachment File"}']"
            if(params."Private Attachment"==true){
                verify.IDChildren << "./../../DIV[contains(@title,'Private attachment')]"
                VerifyNumberOfMatches.run(verify)
            }
            else if(params."Private Attachment"==false){
                VerifyNumberOfMatches.run(verify)
                verify.IDChildren << "./../../DIV[contains(@title,'Private attachment')]"
                verify."Number of Matches"=0
                VerifyNumberOfMatches.run(verify)
           }
            else{VerifyNumberOfMatches.run(verify)} 
      }
            
   }
}