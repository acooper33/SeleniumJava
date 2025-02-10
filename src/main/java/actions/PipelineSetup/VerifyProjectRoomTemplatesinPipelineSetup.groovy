package actions.PipelineSetup;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*
import actions.PipelineSetup.SetLeftSideTabInPipelineSetup
    
class VerifyProjectRoomTemplatesinPipelineSetup{
    public void run(def params){
        
        if(params."Tab"){
            SetLeftSideTabInPipelineSetup.run(Tab:params."Tab")
        }
        def verify = [:]
        verify.IDChildren = []
        if(params."Row Number"){
        verify.ID = "//TABLE[@class='body_table']//TR[${params."Row Number"}]/TD[contains(@class,'template-name')]/A[text()='${params."Template Title"}']"
        } else {
         verify.ID = "//TABLE[@class='body_table']//TD[contains(@class,'template-name')]/A[text()='${params."Template Title"}']"
        }
        if(params."Created By"){verify.IDChildren << "./../../TD[@class='screenname-cell sortable renderable' and text()='${params."Created By"}']"}
        if(params."Created"){verify.IDChildren << "./../../TD[@class='date-created-cell sortable renderable' and text()='${params."Created"}']"}
        if(params."Shared"){verify.IDChildren << "./../../TD[@class='shared-cell sortable renderable' and text()='${params."Shared"}']"}
        if(params."Challenges"){verify.IDChildren << "./../../TD[contains(@class,'pipelines-in-use-') and .='${params."Challenges"}']"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)
        if(params."Access the Template"==true){
            Click.run(ID:verify.ID)
        }
    }
}
