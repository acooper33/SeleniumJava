package actions.SetupEnterpriseCommunities;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifythesubpipelinesandcommunitiesinCommunitiestab{
    public void run(def params){
        
        def verify = [:]
        verify.ID = "//*[contains(@onclick,'${params."Parent Community Name"}')]/following-sibling::DIV[@class='element_hidden'][1]//*[@class='ws_left' and .='${params."Sub Pipeline or Community Name"}']"
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        
        VerifyNumberOfMatches.run(verify) 
        
    }
}