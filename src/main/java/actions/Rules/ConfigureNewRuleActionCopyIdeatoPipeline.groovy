package actions.Rules;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SetCheckBox
import actions.selenium.SetCombobox

class ConfigureNewRuleActionCopyIdeatoPipeline{
    public void run(def params){
        
         if(params."Pipeline"){
             SetCombobox.run(ID:"//*[contains(@id,'move-idea-combobox-')]", Option:params."Pipeline")           
        }
        if(params."Append Additional Info to description"==true){
            Click.run(ID:"//*[contains(@class,'f-copy-move-idea-body')][1]/DIV//DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'wrapper'))]/..//SPAN[text()='Append Additional Info to description']/../../..//*[contains(@class,'f-checkbox-outer')]", "Type of Click":"Move to Element")
        } else if(params."Append Additional Info to description"==false) {
                Click.run(ID:"//*[contains(@class,'f-copy-move-idea-body')][1]/DIV//DIV[contains(@class,'f-checkbox-checked') and contains(@class,'wrapper')]/..//SPAN[text()='Append Additional Info to description']/../../..//*[contains(@class,'f-checkbox-outer')]", "Type of Click":"Move to Element")
        }
        if(params."Append extra submission questions to description"==true){
            Click.run(ID:"//*[contains(@class,'f-copy-move-idea-body')][1]/DIV//DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'wrapper'))]/..//SPAN[text()='Append extra submission questions to description']/../../..//*[contains(@class,'f-checkbox-outer')]", "Type of Click":"Move to Element")
        } else if(params."Append extra submission questions to description"==false) {
                Click.run(ID:"//*[contains(@class,'f-copy-move-idea-body')][1]/DIV//DIV[contains(@class,'f-checkbox-checked') and contains(@class,'wrapper')]/..//SPAN[text()='Append extra submission questions to description']/../../..//*[contains(@class,'f-checkbox-outer')]", "Type of Click":"Move to Element")
        }
		if(params."Copy Attachments"==true){
            Click.run(ID:"//*[contains(@class,'f-copy-move-idea-body')][1]/DIV//DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'wrapper'))]/..//SPAN[text()='Copy Attachments']/../../..//*[contains(@class,'f-checkbox-outer')]", "Type of Click":"Move to Element")
        } else if(params."Copy Attachments"==false) {
                Click.run(ID:"//*[contains(@class,'f-copy-move-idea-body')][1]/DIV//DIV[contains(@class,'f-checkbox-checked') and contains(@class,'wrapper')]/..//SPAN[text()='Copy Attachments']/../../..//*[contains(@class,'f-checkbox-outer')]", "Type of Click":"Move to Element")
        }
        if(params."Copy Comments"==true){
            Click.run(ID:"//*[contains(@class,'f-copy-move-idea-body')][1]/DIV//DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'wrapper'))]/..//SPAN[text()='Copy Comments']/../../..//*[contains(@class,'f-checkbox-outer')]", "Type of Click":"Move to Element")
        } else if(params."Copy Comments"==false) {
                Click.run(ID:"//*[contains(@class,'f-copy-move-idea-body')][1]/DIV//DIV[contains(@class,'f-checkbox-checked') and contains(@class,'wrapper')]/..//SPAN[text()='Copy Comments']/../../..//*[contains(@class,'f-checkbox-outer')]", "Type of Click":"Move to Element")
        }
        if(params."Copy Votes"==true){
            Click.run(ID:"//*[contains(@class,'f-copy-move-idea-body')][1]/DIV//DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'wrapper'))]/..//SPAN[text()='Copy Votes']/../../..//*[contains(@class,'f-checkbox-outer')]", "Type of Click":"Move to Element")
        } else if(params."Copy Votes"==false) {
                Click.run(ID:"//*[contains(@class,'f-copy-move-idea-body')][1]/DIV//DIV[contains(@class,'f-checkbox-checked') and contains(@class,'wrapper')]/..//SPAN[text()='Copy Votes']/../../..//*[contains(@class,'f-checkbox-outer')]", "Type of Click":"Move to Element")
        }
        if(params."Link Ideas"==true){
            Click.run(ID:"//*[contains(@class,'f-copy-move-idea-body')][1]/DIV//DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'wrapper'))]/..//SPAN[text()='Link Ideas']/../../..//*[contains(@class,'f-checkbox-outer')]", "Type of Click":"Move to Element")
        } else if(params."Link Ideas"==false) {
                Click.run(ID:"//*[contains(@class,'f-copy-move-idea-body')][1]/DIV//DIV[contains(@class,'f-checkbox-checked') and contains(@class,'wrapper')]/..//SPAN[text()='Link Ideas']/../../..//*[contains(@class,'f-checkbox-outer')]", "Type of Click":"Move to Element")
        }
    }
}
