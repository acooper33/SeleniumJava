package actions.ViewIdea30;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Exists

class VerifyAttachmentinViewIdea3Page{
    public void run(def params){
        
        if(params."Attachment Header Count"){
            assert Exists.run(ID:"//*[@class='f-component-title' and .='Attachments (${params."Attachment Header Count"})']")==1, "Error - 'Incorrect attachment count in View Idea3 page"
        }
        def verify = [:]
        verify.IDChildren = []
        verify.ID= "//*[@class='f-filedisplay-image-slide']/../..//*[@class='f-images-horizontal-scroll']//*[contains(text(),'${params."Attachment File"}')]"  
        if(params."Should it have cover image icon"){
            def img
            if(params."Should it have cover image icon" == true){img = "./../..//I[contains(@class,'far fa-image-polaroid')]"}
            else{img = "./../..//I[not(contains(@class,'far fa-image-polaroid'))]"}
            verify.IDChildren << "${img}"
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)          
    }
}