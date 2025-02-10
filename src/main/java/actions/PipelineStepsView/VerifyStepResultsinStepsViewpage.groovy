package actions.PipelineStepsView;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyStepResultsinStepsViewpage{
    public void run(def params){
        
        if(params."Step Name"){
            
        	def verify=[:]
            if (params."Idea Code") {
                verify.ID ="//SPAN[@class='step_header_name' and text()='${params."Step Name"}']/../../..//DIV[contains(@id,'step-content')]//DIV[@id='content-inside']/DIV[@class='content-id ']/P/SPAN/A[contains(text(),'${params."Idea Code"}')]"   
            }
            if(params."Idea Name"){
                verify.ID ="//SPAN[@class='step_header_name' and text()='${params."Step Name"}']/../../..//DIV[@id='content-inside']/DIV[contains(@class,'content-id')]/P[contains(.,'${params."Idea Name"}')]"   
            }
            verify.IDChildren = []
            if (params."Score"){
                verify.IDChildren << "./../../../..//DIV[@class='eval-results-square']/SPAN[text()='${params."Score"}']"
            }
            else if (params."Completion"==true){
                verify.IDChildren << "./../../../..//DIV[@class='eval-results-square']//I[@class='fa fa-check']"
            }
            else if (params."Completion"==false){
                verify.IDChildren << "./../../../..//DIV[@class='eval-results-square']/SPAN[@class='dash']"
            }
            if(params."Number of Matches"){
                verify."Number of Matches"=params."Number of Matches".toInteger()
            }else{
                verify."Number of Matches"=1
            }
            verify.Timeout=15
            VerifyNumberOfMatches.run(verify) 
    	}        
    }
}