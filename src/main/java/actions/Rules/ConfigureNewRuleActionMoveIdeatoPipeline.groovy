package actions.Rules;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SetCheckBox
import actions.selenium.SetCombobox

class ConfigureNewRuleActionMoveIdeatoPipeline{
    public void run(def params){
           
         if(params."Move To Pipeline"){
            SetCombobox.run(ID:"//*[contains(@id,'move-idea-combobox-')]", Option:params."Move To Pipeline")
         }
        if(params."Category"){
            SetCombobox.run(ID:"//*[contains(@id,'select-category-combobox')]", Option:params."Category")
        }
        if(params."Status"){
            SetCombobox.run(ID:"//*[contains(@id,'select-status-combobox')]", Option:params."Status")
        }
        if(params."Append extra submission questions to description"==true){
            Click.run(ID:"//*[contains(@class,'f-move-idea-checkbox-container')][1]/DIV/DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'wrapper'))]/..//SPAN[text()='Append extra submission questions to description']/../../..//*[contains(@class,'f-checkbox-outer')]", "Type of Click":"Move to Element")
        } else if(params."Append extra submission questions to description"==false) {
                Click.run(ID:"//*[contains(@class,'f-move-idea-checkbox-container')][1]/DIV/DIV[contains(@class,'f-checkbox-checked') and contains(@class,'wrapper')]/..//SPAN[text()='Append extra submission questions to description']/../../..//*[contains(@class,'f-checkbox-outer')]", "Type of Click":"Move to Element")
        }
        if(params."Notify submitter(s)"==true){
            Click.run(ID:"//*[contains(@class,'f-move-idea-checkbox-container')][2]/DIV/DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'wrapper'))]/..//SPAN[text()='Notify submitter(s)']/../../..//*[contains(@class,'f-checkbox-outer')]", "Type of Click":"Move to Element")
        } else if(params."Notify submitter(s)"==false) {
                Click.run(ID:"//*[contains(@class,'f-move-idea-checkbox-container')][2]/DIV/DIV[contains(@class,'f-checkbox-checked') and contains(@class,'wrapper')]/..//SPAN[text()='Notify submitter(s)']/../../..//*[contains(@class,'f-checkbox-outer')]", "Type of Click":"Move to Element")
        }
    }
}