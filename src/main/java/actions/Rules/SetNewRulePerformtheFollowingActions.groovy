package actions.Rules;

import actions.selenium.*
import actions.selenium.utils.Elements
import actions.common.AppsCommon

class SetNewRulePerformtheFollowingActions{
    public void run(def params){
        
        if(params."Add, Delete or Modify"=="Delete"){Click.run(ID:"//*[contains(@class,'f-rules-section')][4]//DIV[@class='f-condition-component'][${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//I[contains(@class,'far fa-times')]")}
        
        else{
            if(params."Add, Delete or Modify"=="Add"){
                Click.run(ID:"//*[contains(@class,'f-condition-add')]/*[text()='Add Action']")
            }
            if(params."Perform Following Action"){
                 Click.run(ID:"//*[contains(@class,'f-rules-section')][4]//DIV[@class='f-condition-component'][${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//*[contains(@id,'f-actions-dropdown')]")
                 sleep(2000)
                 Click.run(ID:"//*[@id='f-combobox-list' and contains(@style,'display: flex')]//*[text()='${params."Perform Following Action"}']", "Type of Click":"Move to Element")
            }
             if(params."Action Value"){
                 Click.run(ID:"//*[contains(@class,'f-rules-section')][4]//DIV[@class='f-condition-component'][${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//*[contains(@id,'f-select-status')]")
                 sleep(2000)
                 Click.run(ID:"//*[@id='f-combobox-list' and contains(@style,'display: flex')]//*[text()='${params."Action Value"}']")
               
            }
            if(params."Perform Following Action"=="Send Email"){
                if(params."Send Email Recipent Group"){
                    Click.run(ID:"//*[contains(@class,'f-rules-section')][4]//DIV[@class='f-condition-component'][${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//*[contains(@id,'f-select-status')]")
                 	sleep(2000)
                 	Click.run(ID:"//*[@id='f-combobox-list' and contains(@style,'display: flex')]//*[text()='${params."Send Email Recipent Group"}']")     
                }
                if(params."Select Recipient"){
                    AppsCommon.NewUserPickerAddRemoveInDuplicateNewModal("Field Name":"",User:params."Select Recipient","Add or Remove":"Add")
                }
                if(params."Send Email Template"){
                    SetText.run(ID:"//*[contains(@class,'f-rules-section')][4]//DIV[@class='f-condition-component'][${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//*[contains(@class,'f-rules-email-templates')]//*[@id='f-actions-dropdown']",Text:params."Send Email Template", "Type of Clear":"Cut")
                 	sleep(2000)
                 	Click.run(ID:"//*[@id='f-combobox-list' and contains(@style,'display: flex')]//*[text()='${params."Send Email Template"}']", "Type of Click":"Move to Element")
                }
                SetText.run(ID:"//*[contains(@class,'f-rules-section')][4]//DIV[@class='f-condition-component'][${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//*[contains(@class,'f-rule-email-subject')]",Text:params."Send Email Enter Subject","Type of Clear":"None")
                if(params."Send Email Text"){
                   SetFocus.run(ID:"//*[contains(@class,'redactor-in redactor-in')]")
                   SetText.run(ID:"//*[contains(@class,'f-rules-section')][4]//DIV[@class='f-condition-component'][${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//*[contains(@class,'redactor-in redactor-in-')]",Text:params."Send Email Text")
                }
                 if(params."Set Dynamic Field"){
                    Click.run(ID:"//*[contains(@class,'f-rules-section')][4]//DIV[@class='f-condition-component'][${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//*[@class='f-rules-engine-email']//*[@class='f-actions-options']//*[contains(@id,'f-actions-dropdown')]")
                 	sleep(2000)
                 	Click.run(ID:"//*[@id='f-combobox-list' and contains(@style,'display: flex')]//*[text()='${params."Set Dynamic Field"}']")  
                    Click.run(ID:"//*[contains(@class,'f-rules-section')][4]//DIV[@class='f-condition-component'][${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//*[@class='f-rules-engine-email']//*[@class='f-actions-options']//*[@class='far fa-plus']/../../BUTTON")
                }
            }
            if(params."Commenter"){
                AppsCommon.NewUserPickerAddRemoveInDuplicateNewModal("Field Name":"Commenter",User:params."Commenter","Add or Remove":"Add")
            }  
            SetText.run(ID:"//*[@id='f-rules-textarea']", Text:params."Comment", "Type of Clear":"Cut")
        }
    }
}