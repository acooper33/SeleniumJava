package actions.Widgets;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyWidgetExists{
    public void run(def params){
        //Extra text
        //Map all values that will be used for verification for that instance
        def verify = [:]
        verify.ID = "//*[@class='widget_title']//*[starts-with(text(),'${params."Widget Name"}')]"
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        
        VerifyNumberOfMatches.run(verify) 
    }
}