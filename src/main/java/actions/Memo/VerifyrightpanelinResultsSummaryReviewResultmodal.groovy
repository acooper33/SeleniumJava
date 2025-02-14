package actions.Memo;

import actions.selenium.*
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyrightpanelinResultsSummaryReviewResultmodal{
    public void run(def params){
        
        def verify = [:]
        verify.ID = "//*[contains(@class,'f-title') and text()='${params."Question"}']"
        verify.IDChildren = []
        if(params."Slider Value"){
            SetFocus.run(ID: verify.ID+"/../..//*[contains(@data-tooltip-id,'f-score-') and contains(@class,'f-summary-slider-avg')]")
            verify.IDChildren << "./../..//*[contains(@data-tooltip-id,'f-score-')]/..//*[contains(@class,'react-tooltip') and contains (.,'${params."Slider Value"}')]"}
        if(params."Score"){verify.IDChildren << "./../..//*[@class='f-score-container']//*[contains(@class,'f-score')]//*[text()='${params."Score"}']"}
        if (params."Reviewer"){
            params."Reviewer".split(",").eachWithIndex{ reviewer, x ->
                if(params."Reviewer Score"){
                     if(params."Reviewer Score".split(",")[x]!="null"){
                         verify.IDChildren << "./../..//*[@class='f-user-name']//SPAN[text()='${reviewer}']/../..//*[@class='f-score' and .='${params."Reviewer Score".split(",")[x]}']"
                     }
                }
                if(params."Reviewer Comment"){
                    if(params."Reviewer Comment".split(",")[x]!="null"){
                        verify.IDChildren << "./../..//*[@class='f-user-name']//SPAN[text()='${reviewer}']/../../..//*[text()='${params."Reviewer Comment".split(",")[x]}']"  
                    }                    
                }
            }
        }
         if (params."Text Area Comment Reviewer"){
            params."Text Area Comment Reviewer".split(",").eachWithIndex{ reviewer, x ->
                         verify.IDChildren << "./../..//SPAN[text()='${reviewer}']/../..//*[.='${params."Text Area Comment Reviewer".split(",")[x]}']"
                     }
                }  
        if(params."Placement Number") {
            verify.ID="//*[@class='f-result-question'][${params."Placement Number"}]//*[contains(@class,'f-title') and text()='${params."Question"}']"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }        
    }
}
