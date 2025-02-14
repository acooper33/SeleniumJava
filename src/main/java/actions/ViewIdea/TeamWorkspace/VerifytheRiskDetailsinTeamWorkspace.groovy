package actions.ViewIdea.TeamWorkspace;

import actions.selenium.*
import actions.selenium.utils.VerifyNumberOfMatches

class VerifytheRiskDetailsinTeamWorkspace{
    public void run(def params){

        if(Exists.run(ID:"//*[@class='fractal-teamWorkspacePanel-heading']/*[text()='${params."Risk to be Commented"}']")==0){ 
            Click.run(ID:"//*[contains(@id,'table-body-row') and @value='${params."Risk to be Commented"}']") 
        } 
        def verify = [:]
        verify.ID = "//*[@class='fractal-teamWorkspacePanel-heading']/*[text()='${params."Risk to be Commented"}']"        
        verify.IDChildren = []
        if(params."Date"){verify.IDChildren << "./parent::DIV/parent::DIV//DD[contains(.,'${params."Date"}')]"}
        if(params."Status"){verify.IDChildren << "./parent::DIV/parent::DIV//DT[contains(text(),'Status')]/..//DD[contains(.,'${params."Status"}')]"}
        if(params."Related Area"){verify.IDChildren << "./parent::DIV/parent::DIV//DT[contains(text(),'Related Area')]/..//DD[contains(.,'${params."Related Area"}')]"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)        
    }
}