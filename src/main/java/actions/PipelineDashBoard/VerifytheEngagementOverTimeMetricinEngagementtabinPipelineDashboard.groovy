package actions.PipelineDashBoard;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Exists

class VerifytheEngagementOverTimeMetricinEngagementtabinPipelineDashboard{
    public void run(def params){

        def verify = [:]
        if(Exists.run(ID:"//*[@id='overall-metrics-region']")>0){
            verify.ID = "//*[@id='overall-metrics']//table//tbody//td//*[contains(.,'${params."Metric Label"}')]"
        } else {
            verify.ID = "//*[contains(@class,'metrics-container')]//*[contains(@class,'metric')]/*[.='${params."Metric Label"}']"
        }
        //verify.ID = "//*[contains(@class,'f-metrics-container')]//*[@class='f-metric']/*[.='${params."Metric Label"}']"
        
        verify.IDChildren = []
        if(params."Value"){
        	verify.IDChildren << "./../*[starts-with(.,'${params."Value"}')]"
        }
        if(params."Placement Number") {
            if(Exists.run(ID:"//*[@id='overall-metrics-region']")>0){
                verify.ID = "//*[@id='overall-metrics']//table//tbody//td[position()='${params."Placement Number"}']//*[contains(.,'${params."Metric Label"}')]"
            } else {
                verify.ID = "//*[contains(@class,'metrics-container')]//*[contains(@class,'metric') and position()='${params."Placement Number"}']/*[.='${params."Metric Label"}']" 
            }
            //verify.ID = "//*[contains(@class,'f-metrics-container')]//*[@class='f-metric' and position()='${params."Placement Number"}']/*[.='${params."Metric Label"}']"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
    }
}