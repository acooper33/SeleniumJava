package actions.PipelineManageSteps;

import actions.selenium.Click
import actions.selenium.utils.VerifyNumberOfMatches



class VerifyStepHistoryinManageStep{
    public void run(def params){
        
        if(params."Step Name to Manage (optional)"){
            Click.run(ID:"//SPAN[@class='step_header_name' and text()='${params."Step Name to Manage (optional)"}']/../DIV[contains(@class,'img-dropdown')]")
            Click.run(ID:"//SPAN[@class='step_header_name' and text()='${params."Step Name to Manage (optional)"}']/../..//*[text()='Manage ${params."Step Name to Manage (optional)"}']")
        }
        
        Click.run(ID:"//*[@id='history-tab']")
        
        if(params."Row Number"){
            def verify = [:]
        	verify.IDChildren = []
            verify.ID = "//TABLE[@class='body_table']//TR[${params."Row Number"}]"
            
            if(params."Idea Name"){verify.IDChildren << "./TD[@class='title-cell sortable renderable' and text()='${params."Idea Name"}']"}
            if(params."Resolution"){verify.IDChildren << "./TD[@class='string-cell decision-cell renderable' and text()='${params."Resolution"}']"}
            if(params."Decision Maker"){verify.IDChildren << "./TD[@class='string-cell decision-maker-cell renderable' and text()='${params."Decision Maker"}']"}
            
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)
        }
    }
}