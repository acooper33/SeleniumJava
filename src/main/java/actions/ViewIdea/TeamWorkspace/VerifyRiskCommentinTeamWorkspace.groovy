package actions.ViewIdea.TeamWorkspace;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*

class VerifyRiskCommentinTeamWorkspace{
    public void run(def params){

        if(Exists.run(ID:"//*[@class='fractal-teamWorkspacePanel-heading']/*[text()='${params."Risk to be Commented"}']")==0){ 
            Click.run(ID:"//*[contains(@id,'table-body-row') and @value='${params."Risk to be Commented"}']") 
        } 
        def verify = [:]
        verify.ID = "//*[contains(@class,'fractal-comment-top-parent')]//*[contains(text(),'${params."Comment"}')]"        
        verify.IDChildren = []
        if(params."User"){verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV//*[@class='fractal-member-name' and .='${params."User"}']"}
        if(params."Date and Time"){verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV//*[@class='fractal-comment-date' and text()='${params."Date and Time"}']"}
        if(params."Total Replies"){verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV//*[@class='total-nested-comments' and contains(.,'${params."Total Replies"}')]"}
        if(params."Attachment File"){
            params."Attachment File".split(",").eachWithIndex{ name, x ->
                verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV/parent::DIV//*[contains(@class,'fractal-filelist')]//*[@class='filename' and text()='${name}']"
                sleep(5000)    
            }
        }
        if(params."Placement Number"){
            params."Number of Matches"=1
            verify.ID = "//*[contains(@class,'fractal-comment-top-parent')]/../../DIV[${params."Placement Number"}]//*[contains(text(),'${params."Comment"}')]"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
    }
}