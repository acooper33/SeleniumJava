package actions.Widgets;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*

class VerifyandAccessTagWidgetinWebstorm{
    public void run(def params){
        if(params."Tag Name"){
            def verify = [:]
            verify.ID = "//*[contains(@class,'tag_widget')]//A[text()='${params."Tag Name"}']"
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
            if(params."Click to access"==true){Click.run(verify)}
        }
        if(params."More Link"==true){Click.run(ID:"//*[contains(@class,'tags_widget')]//A[contains(text(),'more')]")}
    }
}