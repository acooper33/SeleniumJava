package actions.PipelineStepsView;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyAssigneeInUpdateAssigneeModal{
    public void run(def params){
    
        if(params."Open Modal"==true){
            SetActionMenuinPipelineStepsView.run("Menu Option":"Update Assignees...")
        }
        def verify = [:]
        if(params."Assignee under Completed or Incomplete Action Items"){
            if(params."Assignee under Completed or Incomplete Action Items"=="Assignees with incomplete action items"){
                verify.ID = "//*[contains(@class,'f-incomplete-actions')]//*[contains(@class,'f-member-pill') and text()='${params."Assignee"}']"
            } else {
                verify.ID = "//*[contains(@class,'f-complete-actions')]//*[contains(@class,'f-member-pill') and text()='${params."Assignee"}']"
            }
        } else {
            verify.ID = "//*[contains(@class,'f-member-pill') and text()='${params."Assignee"}']"
        }
        verify.IDChildren = []
        if(params."Display Image"){
            def img
            if(params."Display Image"=="Image"){img = "/IMG[contains(@src,'ct/getfile')]"}
            else{img = "/DIV[contains(@class,'member-initial')]/*[text()='${params."Display Image"}']"}
            verify.IDChildren << "./${img}"
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify) 
    }    
}