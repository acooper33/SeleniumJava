package actions.ViewIdea.TeamWorkspace;

import actions.common.TeamWorkspaceCommon
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyRiskiestAssumptionsinTeamWorkspace{
    public void run(def params){
        if(params."Verify in Which Tab (optional)"){TeamWorkspaceCommon.NavigateTab(Tab:params."Verify in Which Tab (optional)")}

        def verify = [:]
        verify.ID = "//*[@class='grid-input-container']/INPUT[@value='${params."Risk"}']"
        verify.IDChildren = []

        if(params."Related Area"){verify.IDChildren << "./../../..//*[@class='grid-dropdown-value' and text()='${params."Related Area"}']"}
        if(params."Status"){verify.IDChildren << "./../../..//*[contains(@class,'grid-dropdown-value') and text()='${params."Status"}']"}
        if(params."Placement Number"){
            params."Number of Matches"=1
            verify.ID ="//*[@id='table-body']//DIV[${params."Placement Number"}][contains(@class,'fractal-table-row')]//*[contains(@id,'input') and @value='${params."Risk"}']"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)
        }
    }
}