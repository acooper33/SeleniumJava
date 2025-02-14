package actions.Search;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Click

class VerifyOnGlobalSearchResult{
    public void run(def params){
        
    	def verify = [:]
        if(params."Type"){
             verify.ID = "//*[contains(@class,'results-type')and text()='${params."Type"}']/../..//*[contains(@class,'result-title') and text()='${params."Title"}']"  
        } else {
            verify.ID = "//*[contains(@class,'result-title') and text()='${params."Title"}']"    
        }
        verify.IDChildren = []
        if(params."Description"){verify.IDChildren << "./..//*[@class='result-desc' and text()='${params."Description"}']"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)        
        if(params."Click on the result" == true){
            Click.run(verify)
        }
    }
}