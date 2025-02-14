package actions.ViewIdeaOutcomes;

import actions.common.ViewIdeaCommon
import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Click

class VerifyOutcomeViewIdea{
    public void run(def params){
     	ViewIdeaCommon.NavigateTab("Tab":"Outcomes")
        
        //Map all values that will be used for verification for that outcome
        def verify = [:]
        verify.ID ="//*[@class='outcome-name']/*[contains(text(),'${params."Outcome Name"}')]" 
        verify.IDChildren = []
        //if(params."Type"!=null){ verify.IDChildren << "./../..//*[@class='outcome-type' and contains(text(),'${params."Type"}')]"}
        if(params."Type"!=null){ verify.IDChildren << "./../..//*[@class='outcome-type' and text()='${params."Type"}']"}
        if(params."Amount"!=null){ verify.IDChildren << "./../../..//*[@class='outcome-amount'and text()='${params."Amount"}']"}
        if (params."Description"!=null){verify.IDChildren << "./../../../../..//*[@class='expanded-content']/*[@class='outcome-description' and text()='${params."Description"}']"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        
        VerifyNumberOfMatches.run(verify)
    }
}