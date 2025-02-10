package actions.PipelineStepsView;

import actions.selenium.ExplicitWait
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyCompaniesinScoutAIModal{
    public void run(def params){
        
        ExplicitWait.run(ID:"//*[contains(@class,'f-import-with-ai-results-item-wrapper')]") 
        def verify = [:]
        if(params."Placement Number"){verify.ID = "//*[contains(@class,'f-import-with-ai-results-item-wrapper')]/DIV[${params."Placement Number"}]//*[contains(@class,'f-import-with-ai-results-item-name') and contains(text(),'${params."Company Name"}')]"}	
        else{verify.ID = "//*[contains(@class,'f-import-with-ai-results-item-wrapper')]/DIV//*[contains(@class,'f-import-with-ai-results-item-name') and contains(text(),'${params."Company Name"}')]"}
        
        verify.IDChildren = []
        if(params."Description"){verify.IDChildren << "./..//*[contains(@class,'f-import-with-ai-results-item-desc') and contains(text(),'${params."Description"}')]"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify) 
    }
}