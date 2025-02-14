package actions.Memo;

import actions.selenium.*
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyReviewResults{
    public void run(def params){
        
        def verify = [:]
        verify.ID = "//*[@class='f-round-name' and text()='${params."Round Name"}']"
        verify.IDChildren = []
        if(params."Score"){verify.IDChildren << "./..//*[@class='f-round-score' and text()='${params."Score"}']"}
        if(params."Score Color"){verify.IDChildren << "./..//*[@class='f-round-score-container f-${params."Score Color"}']"}
        if(params."Assigned on"){verify.IDChildren << "./../..//*[.='${params."Assigned on"}']"}
        if(params."Progress Bar width completed"){verify.IDChildren << "./../..//*[@class='f-progress-bar' and contains(@style,'${params."Progress Bar width completed"}')]"}
        if(params."Complete"){verify.IDChildren << "./../..//*[@class='f-round-complete-container' and contains(.,'${params."Complete"}')]"}
        if(params."Due Date or Completed"){verify.IDChildren << "./../..//*[@class='f-round-complete-container' and contains(.,'${params."Due Date or Completed"}')]"}
        if(params."Placement Number") {
            verify.ID="//*[@class='f-round-container'][${params."Placement Number"}]//*[@class='f-round-name' and text()='${params."Round Name"}']"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
        if(params."View Results"==true){
            Click.run(ID:verify.ID+"/../..//*[contains(@class,'f-btn-xs f-btn-standard')]")
        }
    }
}
