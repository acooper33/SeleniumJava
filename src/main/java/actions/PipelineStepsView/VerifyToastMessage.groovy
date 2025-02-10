package actions.PipelineStepsView;

import actions.selenium.ExplicitWait
import actions.selenium.*

class VerifyToastMessage{
    public void run(def params){
        
        if(Exists.run(ID:"//*[contains(@class,'f-import-with-ai-results-item-wrapper')]")==0){
            ExplicitWait.run(ID:"//*[text()='${params."Toast Message"}']")
        }                
    }
}