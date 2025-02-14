package actions.Widgets;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*

class VerifyandAccessWidgetMiniTagCloud{
    public void run(def params){
        def verify = [:]
        verify.ID = "//*[@class='widget_container mini_tag_cloud_widget']//A[text()='${params."Tag Name"}']"
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)        
        if(params."Click to access"){Click.run(ID:"//*[@class='widget_container mini_tag_cloud_widget']//A[text()='${params."Tag Name"}']")}
    }
}