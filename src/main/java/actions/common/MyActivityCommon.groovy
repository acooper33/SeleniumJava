package actions.common;

import actions.selenium.Click

class MyActivityCommon{
    public static void NavigateTab(def params){
        switch(params.Tab){
            case "Submissions":
            	Click.run(ID:"//A[contains(.,'Submissions')]")
            	break
             case "Subscriptions":
            	Click.run(ID:"//*[text()='Subscriptions']")
            	break
            case "Messages":
            	Click.run(ID:"//*[@id='messages']/*[text()='Messages']")
            	break
        }
    }
}