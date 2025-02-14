package actions.Rules;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SetCheckBox

class ConfigureRuleActionMoveIdeatoPipeline{
    public void run(def params){
        if(params."Move To Pipeline"){
			SetText.run(ID:"//*[@id='move-idea-combobox']",Text:params."Move To Pipeline")
            Click.run(ID:"//*[@id='f-combobox-list']//*[text()='${params."Move To Pipeline"}']")         
        }
        if(params."Category"){
            SetText.run(ID:"//*[@class='f-move-idea-category-dropdown-container']//*[@id='select-category-combobox']",Text:params."Category")
            Click.run(ID:"//*[@id='f-combobox-list']//*[text()='${params."Category"}']") 
            
        }
        if(params."Status"){
            SetText.run(ID:"//*[@class='f-move-idea-status-dropdown-container']//*[@id='select-category-combobox']",Text:params."Status")
            Click.run(ID:"//*[@id='f-combobox-list']//*[text()='${params."Status"}']") 
            
        }
        SetCheckBox.run(ID:"//*[@id='checkbox-appendExtraSubmissionQuestions']", Check:params."Append extra submission questions to description")
        SetCheckBox.run(ID:"//*[@id='checkbox-notifySubmitter']", Check:params."Notify submitter(s)")
        sleep(2000)
        if(params.Action=="Save"){Click.run(ID:"//*[@data-test='modal-footer-submit']")}
        else{Click.run(ID:"//*[@data-test='modal-footer-cancel']")}      
    }
}