package actions.ViewIdea;

import actions.common.ViewIdeaCommon
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyVotestabinViewIdeapage{
    public void run(def params){
        ViewIdeaCommon.NavigateTab(Tab:"Votes")
        
        //Map all values that will be used for verification for that instance
        def verify = [:]
        verify.IDChildren = []
        if(params."Types of Vote"=="Promotes"){verify.ID= "//*[@class='history-content-container left']//*[text()='${params.User}']"}
        else{verify.ID= "//*[@class='history-content-container right']//*[text()='${params.User}']"}
        if(params."Promote or Demote Reason"){verify.IDChildren << "./../../*[@class='history-reason-text' and text()='${params."Promote or Demote Reason"}']"}       
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        
        VerifyNumberOfMatches.run(verify) 
    }
}