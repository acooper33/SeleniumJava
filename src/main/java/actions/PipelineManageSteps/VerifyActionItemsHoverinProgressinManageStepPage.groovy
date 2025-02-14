package actions.PipelineManageSteps;

import actions.selenium.*
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyActionItemsHoverinProgressinManageStepPage{
    public void run(def params){

        MouseOver.run(ID:"//*[@class='screener-cell sortable renderable']/A[text()='${params."Evaluator to Hover"}']/../..//*[contains(@class,'percent-wrapper')]")
        def verify = [:]
        verify.ID = "//*[@id='idea-submitter']//*[text()='${params."Evaluator Name in the Hover"}']"
        verify.IDChildren = []
        if(params."User Image" !=null){
            def img
            if(params."User Image"){
                img = "//IMG[contains(@src,'/ct/getfile.php')]"}
            else {img = "//IMG[contains(@src,'/ct/images/')]"}
            verify.IDChildren << "./..${img}"
        }
        if(params."Number of Assigned Action Items"){verify.IDChildren << "./../..//*[@class='total num' and text()='${params."Number of Assigned Action Items"}']"}
        if(params."Number of Completed Action Items"){verify.IDChildren << "./../..//*[@class='completed num' and text()='${params."Number of Completed Action Items"}']"}
        if(params."Number of Cancelled Action Items"){verify.IDChildren << "./../..//*[@class='canceled num' and text()='${params."Number of Cancelled Action Items"}']"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)        
    }
}

