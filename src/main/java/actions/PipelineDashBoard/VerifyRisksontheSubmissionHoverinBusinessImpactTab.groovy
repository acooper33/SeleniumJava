package actions.PipelineDashBoard;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*

class VerifyRisksontheSubmissionHoverinBusinessImpactTab{
    public void run(def params){

        if(params."Unresolved Risk"){
            def verify = [:]
            verify.ID = "//*[@class='risk-name' and text()='${params."Unresolved Risk"}']"
            if(params."Row Number"){
                params."Number of Matches"=1
                verify.ID = "//*[@class='risk-section'][${params."Row Number".toInteger()+1}]/*[@class='risk-name' and text()='${params."Unresolved Risk"}']"
                VerifyNumberOfMatches.run(verify)
            }
            else{
                if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
                VerifyNumberOfMatches.run(verify)
            }
        }
        if(params."View All Risks"==true){
            Click.run(ID:"//*[@class='risks-tab']//A","Type of Click":"Javascript")
        }
    }
}