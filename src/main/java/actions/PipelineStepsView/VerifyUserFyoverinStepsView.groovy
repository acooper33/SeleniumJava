package actions.PipelineStepsView;

import actions.selenium.MouseOver
import actions.selenium.Click
import actions.selenium.utils.VerifyNumberOfMatches


class VerifyUserFyoverinStepsView{
    public void run(def params){
        
        if(params."Area to access the Flyover"=="Pipeline List" || params."Area to access the Flyover"=="Innovations List"){
            MouseOver.run(ID:"//*[@id='grid_holder']/DIV//A[contains(.,'${params."Idea Name"}')]") 
        } else {
          MouseOver.run(ID:"//*[@id='content-inside']/DIV//P[contains(.,'${params."Idea Name"}')]/.//A")  
        }
               
        def verify = [:]
        verify.ID = "//*[@id='idea-title' and text()='${params."Idea Name"}']"
        verify.IDChildren = []
        if(params."Submitter Name"){verify.IDChildren << "./../../DIV[@id='idea-submitter']/A[text()='${params."Submitter Name"}']"}
        if(params."Idea Description"){verify.IDChildren << "./../..//DIV[contains(@id, 'idea-body') and contains(.,'${params."Idea Description"}')]"}
        //if(params."Idea Description"){verify.IDChildren << "./../..//DIV[contains(@id, 'idea-body')]/P[text()='${params."Idea Description"}']"}
        if(params."Status"){verify.IDChildren << "./../..//DIV[@id='idea-status']//*[text()='${params."Status"}']"}
        if(params."Category"){verify.IDChildren << "./../..//DIV[@id='idea-category']//*[contains(text(),'${params."Category"}')]"}
        verify."Number of Matches"=1
        verify.Timeout=15
        VerifyNumberOfMatches.run(verify) 
        
    }
}