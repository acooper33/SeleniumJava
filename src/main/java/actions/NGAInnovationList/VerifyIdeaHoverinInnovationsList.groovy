package actions.NGAInnovationList;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*

class VerifyIdeaHoverinInnovationsList{
    public void run(def params){
        
        MouseOver.run(ID:"//*[@class='idea-has-link' and text()='${params."Idea"}']")
        
        def verify = [:]
        verify.IDChildren = []
        verify.ID = "//*[@id='e2e-idea-tooltip']//*[@id='idea-title' and text()='${params."Idea Name in the Hover"}']"
        if(params."Submitter Name"){verify.IDChildren << "./../..//*[@id='idea-submitter']/*[text()='${params."Submitter Name"}']"}
        if(params."Description"){verify.IDChildren << "./../..//*[@id='e2e-idea-body']/*[text()='${params."Description"}']"}
        if(params."Submitted"){verify.IDChildren << "./../..//*[@id='idea-date']/*[text()='${params."Submitted"}']"}
        if(params."Submitted"){verify.IDChildren << "./../..//*[@id='idea-date']/*[text()='${params."Submitted"}']"}
        if(params."Status"){verify.IDChildren << "./../..//*[@id='idea-status']/*[text()='${params."Status"}']"}
        if(params."Number of Days"){verify.IDChildren << "./../..//*[@id='idea-score']/*[contains(text(),'${params."Number of Days"}')]"}
        if(params."Category"){verify.IDChildren << "./../..//*[@id='idea-category']/*[contains(text(),'${params."Category"}')]"}
        if(params."Number of Matches"){
            verify."Number of Matches" = params."Number of Matches".toInteger()
        }
        VerifyNumberOfMatches.run(verify)
    }       
}