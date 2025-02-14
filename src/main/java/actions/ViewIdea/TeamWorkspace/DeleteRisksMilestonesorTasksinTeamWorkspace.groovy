package actions.ViewIdea.TeamWorkspace;

import actions.common.TeamWorkspaceCommon
import actions.selenium.*
    
class DeleteRisksMilestonesorTasksinTeamWorkspace{
    public void run(def params){
        
        if(params."Verify in Which Tab (optional)"){TeamWorkspaceCommon.NavigateTab(Tab:params."Verify in Which Tab (optional)")}
        SetFocus.run(ID:"//*[@class='grid-input-container']/INPUT[@value='${params."Risk/Milestone/Task to be Deleted"}']/../../..")
        Click.run(ID:"//*[@class='table-row-delete']/I")
    }
}