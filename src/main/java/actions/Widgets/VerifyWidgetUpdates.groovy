package actions.Widgets;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyWidgetUpdates{
    public void run(def params){
        //Map all values that will be used for verification for that instance
        def verify = [:]
        verify.ID = "//*[@id='ws_updates_area']//*[contains(.,'${params."Update Text Contains"}') and contains(@style,'margin-left')]"
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        
        VerifyNumberOfMatches.run(verify) 
    }
}