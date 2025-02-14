package actions.Rules;

import actions.selenium.*
import actions.common.AppsCommon

class SetNewRuleMeettheFollowingConditions{
    public void run(def params){
        
        if(params."All or Any"){
            Click.run(ID:"//*[contains(@id,'f-condition-type')]/DIV")
            Click.run(ID:"//*[contains(@class,'f-selected-option')]/*[text()='${params."All or Any"}']")
        }        
        if(params."Add, Delete or Modify"=="Delete"){Click.run(ID:"//*[contains(@class,'f-rules-section')][3]//DIV[@class='f-condition-component'][${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//I[contains(@class,'far fa-times')]")}       
        else{
            if(params."Add, Delete or Modify"=="Add"){
                Click.run(ID:"//*[contains(@class,'f-condition-add')]/*[text()='Add Condition']")
            }
            if(params."Condition"){
                Click.run(ID:"//*[contains(@class,'f-rules-section')][3]//DIV[@class='f-condition-component'][${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//*[contains(@id,'f-conditions-dropdown')]")
            	Click.run(ID:"//*[@id='f-combobox-list' and contains(@style,'display: flex')]//*[text()='${params."Condition"}']", "Type of Click":"Move to Element")
            }
            if(params."Operator value"){
                Click.run(ID:"//*[contains(@class,'f-rules-section')][3]//DIV[@class='f-condition-component'][${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//*[contains(@id,'f-condition-operator')]")
                Click.run(ID:"//*[@id='f-combobox-list' and contains(@style,'display: flex')]//*[text()='${params."Operator value"}']", "Type of Click":"Move to Element")
//            	Click.run(ID:"//*[contains(@class,'f-rules-section')][3]//DIV[@class='f-condition-component'][${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//*[contains(@id,'f-condition-operator')]//*[text()='${params."Operator value"}']/..", "Type of Click":"Move to Element")
            }
            if(params."Condition value"){
                if(params."Condition"=="Submitted by"){
                         AppsCommon.NewUserPickerAddRemoveInDuplicateNewModal("Field Name":"",User:params."Condition value","Add or Remove":"Add")
                    } else if(Exists.run(ID:"//*[contains(@class,'f-rules-section')][3]//DIV[@class='f-condition-component'][${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//*[@id='f-conditions-list-dropdown']")>0){
                        SetText.run(ID:"//*[contains(@class,'f-rules-section')][3]//DIV[@class='f-condition-component'][${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//*[@id='f-conditions-list-dropdown']",Text:params."Condition value", "Type of Clear":"Cut")
                		sleep(2000)
            			Click.run(ID:"//*[@id='f-combobox-list' and contains(@style,'display: flex')]//*[text()='${params."Condition value"}']", "Type of Click":"Move to Element")
                    } else if(Exists.run(ID:"//*[contains(@class,'f-rules-section')][3]//DIV[@class='f-condition-component'][${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//*[contains(@id,'f-rule-condition-num-condition')]")>0){
                    SetText.run(ID:"//*[contains(@class,'f-rules-section')][3]//DIV[@class='f-condition-component'][${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//*[contains(@id,'f-rule-condition-num-condition')]",Text:params."Condition value","Type of Clear":"Cut")
                } else if(Exists.run(ID:"//*[contains(@class,'f-rules-section')][3]//DIV[@class='f-condition-component'][${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//*[contains(@id,'f-rules-textarea')]")>0){
                    SetText.run(ID:"//*[contains(@class,'f-rules-section')][3]//DIV[@class='f-condition-component'][${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//*[contains(@id,'f-rules-textarea')]",Text:params."Condition value","Type of Clear":"Cut")
                } 
            }
        }
    }
}