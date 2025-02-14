package actions.NGAViewIdea;

import actions.common.NGAViewIdeaCommon
import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*

class VerifyVotestabinNGAViewIdeapage{
    public void run(def params){
        NGAViewIdeaCommon.NavigateTab(Tab:"Votes")
        
        //Map all values that will be used for verification for that instance
        def verify = [:]
        if(params."Types of Vote"=="Promotes"){verify.ID= "//*[@class='history-content-container left']//*[text()='${params.User}']"}
        else{verify.ID= "//*[@class='history-content-container right']//*[text()='${params.User}']"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        
        VerifyNumberOfMatches.run(verify) 
    }
}