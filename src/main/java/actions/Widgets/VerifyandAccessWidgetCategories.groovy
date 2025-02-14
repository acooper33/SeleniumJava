package actions.Widgets;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*

class VerifyandAccessWidgetCategories{
    public void run(def params){
        def verify = [:]
        verify.ID = "//*[@class='widget_container categories_widget']//A[text()='${params."Category Name"}']"
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)        
        if(params."Click to access"){Click.run(ID:"//*[@class='widget_container categories_widget']//A[text()='${params."Category Name"}']")}
    }
}