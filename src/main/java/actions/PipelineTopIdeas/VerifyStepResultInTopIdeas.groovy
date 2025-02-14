package actions.PipelineTopIdeas;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Exists

class VerifyStepResultInTopIdeas{
    public void run(def params){
        def verify=[:]
        verify.IDChildren = []
        
        if(params."AI Not Existing" == true){
            assert Exists.run(ID:"//*[@class ='f-best-idea-stack   ']//DIV[contains(@class,'f-idea')]//DIV[contains(@class,'f-idea-title')]/SPAN[contains(.,'${params."Idea Title"}')]/../../DIV[contains(@class,'eval-results')]")==0, "Unexpected Score Box Found"
        } else {
            verify.ID = "//*[@class ='f-best-idea-stack   ']//DIV[contains(@class,'f-idea')]//DIV[contains(@class,'f-idea-title')]/SPAN[contains(.,'${params."Idea Title"}')]"
            if(params."AI Not Started" == true){
            	verify.IDChildren << "./../../DIV[contains(@class,'f-eval-results-square')]"
        	}
        	if(params."Completed?" == true){
            	verify.IDChildren << "./../../DIV[contains(@class, 'eval-results') and contains(@class,'f-step-completed')]"
        	}
        	if(params."Score"){
            	verify.IDChildren << "./../../DIV[contains(@class, 'eval-results')]/SPAN[contains(@class,'f-score-text') and .='${params.Score}']"
        	}
            if(params."Number of Matches"){
           		verify."Number of Matches" = params."Number of Matches".toInteger()
        	} else {
        		verify."Number of Matches" = 1
        	}
        	VerifyNumberOfMatches.run(verify)
        }
    }
}