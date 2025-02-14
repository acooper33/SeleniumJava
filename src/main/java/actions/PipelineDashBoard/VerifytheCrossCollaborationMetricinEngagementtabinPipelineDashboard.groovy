package actions.PipelineDashBoard;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.PipelineDashBoard.SetViewByInCrossCollaboration

class VerifytheCrossCollaborationMetricinEngagementtabinPipelineDashboard{
    public void run(def params){
        if(params."View By"){SetViewByInCrossCollaboration.ViewBy(params."View By")}
        sleep(2000)
   		def verify = [:]
        //verify.ID = "//*[@class='kpi-metrics-table']//*[@class='metrics-label' and text()='${params."Metric Label"}']"           
        verify.ID = "//*[contains(@class,'metrics-container')]//*[contains(@class,'f-metric')]//*[.='${params."Metric Label"}']"           
        
        verify.IDChildren = []
        if(params."Value"){
            //verify.IDChildren << "./../DIV[@class='number' and contains(text(),'${params."Value"}')]"
            verify.IDChildren << "./../*[starts-with(.,'${params."Value"}')]"
        }
        if(params."Placement Number") {
            //verify.ID="//TD[${params."Placement Number"}]/*[text()='${params."Metric Label"}']"
            verify.ID = "//*[contains(@class,'metrics-container')]//*[contains(@class,'f-metric') and position()='${params."Placement Number"}']/*[.='${params."Metric Label"}']"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
    }
}