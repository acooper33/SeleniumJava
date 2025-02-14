package actions.IdeaBoard;

import actions.selenium.Exists
import actions.selenium.*
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyVotingUIonIdeaCard{
    public void run(def params){
        
        def verify = [:]
       
        if(params."Voting UI View"=="Disabled"){
            verify.ID = "//*[@data-title='${params."Idea Name"}']//*[contains(@class,'f-card-disabled') and contains(@class,'f-card-voting')]"
        } else {
            verify.ID = "//*[@data-title='${params."Idea Name"}']//*[contains(@class,'f-card-voting')]"
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify) 
    }
}