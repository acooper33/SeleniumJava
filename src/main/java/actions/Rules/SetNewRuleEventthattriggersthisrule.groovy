package actions.Rules;

import actions.selenium.*

class SetNewRuleEventthattriggersthisrule{
    public void run(def params){
        
        if(params."Event"){
            Click.run(ID:"//*[contains(@class,'f-event-trigger-dropdown')]//*[@id='f-event-trigger-dropdown']")
            sleep(2000)
            Click.run(ID:"//*[@id='f-combobox-list' and contains(@style,'display: flex')]//*[text()='${params."Event"}']", "Type of Click":"Move to Element")
        } 
        if(params."Event Value"){
            if(Exists.run(ID:"//*[contains(@class,'f-trigger-step-dropdown')]//*[@id='f-event-trigger-dropdown']")>0){
                if(params."Input Event Value"==true){
                    SetText.run(ID:"//*[contains(@class,'fractal-combobox f-trigger-step-dropdown')]//*[@id='f-event-trigger-dropdown']",Text:params."Event Value")
                } else {
                    Click.run(ID:"//*[contains(@class,'f-trigger-step-dropdown')]//*[@id='f-event-trigger-dropdown']")
                }
                sleep(2000)
            	Click.run(ID:"//*[@id='f-combobox-list' and contains(@style,'display: flex')]//*[text()='${params."Event Value"}']", "Type of Click":"Move to Element")
            }
            else{SetText.run(ID:"//*[not(contains(@class,'f-combobox-list')) and contains(@id,'f-rule-trigger-')]",Text:params."Event Value")}
        }
    }
}