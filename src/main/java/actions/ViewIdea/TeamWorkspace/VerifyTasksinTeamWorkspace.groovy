package actions.ViewIdea.TeamWorkspace;

import actions.common.TeamWorkspaceCommon
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyTasksinTeamWorkspace{
    public void run(def params){
        
    if(params."Verify in Which Tab (optional)"){TeamWorkspaceCommon.NavigateTab(Tab:params."Verify in Which Tab (optional)")}

        def verify = [:]
        verify.ID = "//*[@class='grid-input-container']/INPUT[@value='${params."Todo"}']"
        verify.IDChildren = []

        if(params."Assignee"){verify.IDChildren << "./../../..//*[@class='grid-dropdown-value' and text()='${params."Assignee"}']"}
        if(params."Complete"){
            if(params."Complete"=="TRUE"){verify.IDChildren << "./../../..//*[@class='fa fa-check completed']"}
            else {verify.IDChildren << "./../../..//BUTTON[@data-tooltip-content='Mark Complete']"}
        }
        if(params."Due Date"){verify.IDChildren << "./../../..//*[@class='grid-date-value' and text()='${params."Due Date"}']"}
        if(params."Placement Number"){
            params."Number of Matches"=1
            verify.ID ="//*[@id='table-body']//DIV[${params."Placement Number"}][contains(@class,'fractal-table-row')]//*[contains(@id,'input') and @value='${params."Todo"}']"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)
        }
    }
}