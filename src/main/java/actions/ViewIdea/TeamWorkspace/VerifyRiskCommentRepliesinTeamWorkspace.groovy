package actions.ViewIdea.TeamWorkspace;

import actions.selenium.*
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyRiskCommentRepliesinTeamWorkspace{
    public void run(def params){

        if(Exists.run(ID:"//*[@class='fractal-teamWorkspacePanel-heading']/*[text()='${params."Risk to be Commented"}']")==0){ 
            Click.run(ID:"//*[contains(@id,'table-body-row') and @value='${params."Risk to be Commented"}']") 
        } 
        def verify = [:]
        verify.ID = "//*[contains(text(),'${params."Comment"}')]/../../../..//*[contains(@class,'fractal-htmlpreview')]/DIV/P[contains(text(),'${params."Reply"}')]" 
        verify.IDChildren = []
        if(params."User"){verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV//*[@class='fractal-member-name' and .='${params."User"}']"}
        if(params."Time"){verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV//*[@class='fractal-comment-date' and text()='${params."Time"}']"}
         if(params."Attachment File"){
            params."Attachment File".split(",").eachWithIndex{ name, x ->
                verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV/parent::DIV//*[contains(@class,'fractal-filelist')]//*[@class='filename' and text()='${name}']"
                sleep(5000)    
            }
        }
        if(params."Placement Number"){
            params."Number of Matches"=1
            verify.ID = "//*[contains(text(),'${params."Comment"}')]/../../..//*[contains(@class,'comment-animation-placeholder')]/DIV[${params."Placement Number"}]//*[contains(@class,'fractal-htmlpreview')]/DIV/P[contains(text(),'${params."Reply"}')]"
			VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
    }
}