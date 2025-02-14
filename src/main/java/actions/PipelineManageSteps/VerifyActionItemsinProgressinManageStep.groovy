package actions.PipelineManageSteps;

import actions.selenium.Click
import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Exists
import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement
import actions.selenium.Refresh

class VerifyActionItemsinProgressinManageStep{
    public void run(def params){
        
        def verify = [:]
        verify.IDChildren = []
        
        if(params."Step Name to Manage (optional)"){
            Click.run(ID:"//SPAN[@class='step_header_name' and text()='${params."Step Name to Manage (optional)"}']/../DIV[contains(@class,'img-dropdown')]")
            Click.run(ID:"//SPAN[@class='step_header_name' and text()='${params."Step Name to Manage (optional)"}']/../..//*[contains(text(),'Manage')]")
        }
        Refresh.run()
        Click.run(ID:"//*[@id='progress-tab']")
        sleep(5000)
        
        if(params."Count to verify"){
            sleep(2000)
        	assert (Exists.run(ID: "//div[@id='screener-chart']//*[name()='g'][2]//*[@class='progress-chart-count' and text()='${params."Count to verify"}']", "Timeout":60)>0), "Error - Count does not match"
        }        
        
        if(params."Row Number"){
        	verify.ID = "//table[@class='body_table']/TBODY/TR[${params."Row Number"}]"
            if(params."Development Lead"){verify.IDChildren << "./TD[@class='lead-cell sortable renderable']/A[text()='${params."Development Lead"}']"}
            if(params."Development Team"){verify.IDChildren << "./TD[@class='team-cell sortable renderable']/A[text()='${params."Development Team"}']"}
            if(params.Evaluator){verify.IDChildren << "./TD[@class='screener-cell sortable renderable']/A[text()='${params.Evaluator}']"}
            if(params."Evaluator Removed"){verify.IDChildren << "./TD[@class='screener-cell sortable renderable']/A[text()='${params.Evaluator}']/preceding-sibling::img[contains(@class,'fade-out')]"}
            if(params."Evaluator in group"==true){verify.IDChildren << "./TD[@class='screener-cell sortable renderable']/I[contains(@class,'fas fa-users group-tooltip')]"}
            if(params."Evaluator in group"==false){verify.IDChildren << "./TD[@class='screener-cell sortable renderable']/A[not(following-sibling::*)]"}
            if(params."Overall Score"){verify.IDChildren << "./TD[contains(@class,'overall-score-cell') and text()='${params."Overall Score"}']"}
            if(params."Number of assigned items"){verify.IDChildren << "./TD[@class='assigned-cell sortable renderable' and text()='${params."Number of assigned items"}']"}
            if(params."Number of remaining items"){verify.IDChildren << "./TD[@class='remaining-cell sortable renderable' and text()='${params."Number of remaining items"}']"}
            //also checks that Completed items displayed before Cancelled items in the Percent Complete Bar
            if(params."Percent Complete Bar - Completed"){verify.IDChildren << "./TD[@class='renderable']/DIV[@class='percent-wrapper']/DIV[position()=1]/SPAN[.='${params."Percent Complete Bar - Completed"}']"}
            if(params."Percent Complete Bar - Cancelled"){verify.IDChildren << "./TD[@class='renderable']/DIV[@class='percent-wrapper']/DIV[position()=2]/SPAN[.='${params."Percent Complete Bar - Cancelled"}']"}
			
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)
        }
        if(params.'Array of Assigned Values'|| params.'Array of Remaining Values'){ // does not verify the order
            verify.ID = "//table[@class='body_table']/TBODY"
            verify.IDChildren = []
            if(params.'Array of Assigned Values'){ 
                params.'Array of Assigned Values'.split(",").each{assigned ->
                	verify.IDChildren << "./TR/TD[contains(@class,'assigned-cell') and text()='${assigned}']"
            	}
            }
            if(params.'Array of Remaining Values'){
                params.'Array of Remaining Values'.split(",").each{remaining ->
                	verify.IDChildren << "./TR/TD[contains(@class,'remaining-cell') and text()='${remaining}']"
            	}
        	}
            verify."Number of Matches" = 1
            VerifyNumberOfMatches.run(verify)            
        }
    }
}