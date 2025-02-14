package actions.ViewIdea;

import actions.selenium.Exists

class VerifyEvaluationsTabChartonViewIdea{
    public void run(def params){
        
        if(params."Should Chart Exist"==true){
            if(params."Number of Matches">=1){
                assert Exists.run(ID:" //*[contains(@class,'highcharts-background')]")==params."Number of Matches".toInteger(),"Evaluation chart is missing from the tab"
        	} else 
            	assert Exists.run(ID:" //*[contains(@class,'highcharts-background')]")==0,"Evaluation chart should not be displayed but is visible on the Evaluation tab"        
        }  
    }            
}