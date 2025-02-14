package actions.PipelineDashBoard;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifytheTopIndicatorsonOverallTabinBusinessImpacttab{
    public void run(def params){

        def verify = [:]
        verify.ID = "//*[@class='top-indicators-content top-indicators-title' and text()='${params."Top Indicator"}']"           
        verify.IDChildren = []
        if(params."Value"){verify.IDChildren << "./..//*[@class='top-indicators-content top-indicators-data' and .='${params."Value"}']"}
        if(params."Placement Number") {
            verify.ID="//*[@class='top-indicators-box'][${params."Placement Number"}]//*[@class='top-indicators-content top-indicators-title' and text()='${params."Top Indicator"}']"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
    }
}