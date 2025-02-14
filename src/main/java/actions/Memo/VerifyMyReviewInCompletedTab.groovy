package actions.Memo;

import actions.selenium.*
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyMyReviewInCompletedTab{
    public void run(def params){
               
        def verify = [:]
        verify.ID = "//*[contains(@class,'f-question-header') and .='${params."Question"}']"
        verify.IDChildren = []
        if(params."Slider Value"){verify.IDChildren << "./..//*[contains(@class,'rc-slider-handle') and contains(@aria-valuenow,'${params."Slider Value"}')]"}
        if(params."Score"){verify.IDChildren << "./..//*[contains(@class,'f-completed-value') and text()='${params."Score"}']"}
        if(params."Comment"){verify.IDChildren << "./..//*[contains(@class,'f-question-text-container') and .='${params."Comment"}']"}
       
        if(params."Placement Number") {
            verify.ID="//*[contains(@class,'f-question')][${params."Placement Number"}]//*[contains(@class,'f-question-header') and .='${params."Question"}']"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }        
    }
}
