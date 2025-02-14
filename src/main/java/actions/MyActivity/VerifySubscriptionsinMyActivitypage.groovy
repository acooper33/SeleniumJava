package actions.MyActivity;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.common.MyActivityCommon
import actions.selenium.Click

class VerifySubscriptionsinMyActivitypage{
    public void run(def params){
        
         //Go to Subscriptions tab
        MyActivityCommon.NavigateTab(Tab:"Subscriptions")
        def verify = [:]
        
        switch (params."Value Type to Verify"){
            case "Ideas":
//            	Click.run(ID:"//*[@id='my_subscription_ideas']")
            	verify.ID= "//*[text()='${params."Idea/Webstorm Name"}' and @class='landing_page_content_main_link']"
            	verify.IDChildren = []
            	if(params."Value"){verify.IDChildren << "./following-sibling::DIV/*[text()='${params."Value"}']"}
            	if(params."Subscribed Ideas Comments number"){verify.IDChildren << "./parent::td//*[text()='${params."Subscribed Ideas Comments number"} comments']"}
        		if(params."Subscribed Ideas Status"){verify.IDChildren << "./parent::td/following-sibling::td//*[contains(text(),'${"Subscribed Ideas Status"}')]"}        
        		if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            	VerifyNumberOfMatches.run(verify)
            	break            	
            case "Webstorms":
            	Click.run(ID:"//*[@id='my_subscription_webstorms']/A")
            	verify.ID= "//*[text()='${params."Idea/Webstorm Name"}' and @class='landing_page_content_main_link']"
            	if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            	VerifyNumberOfMatches.run(verify)
            	break
        }        
    }
}
