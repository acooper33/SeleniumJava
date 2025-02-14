package actions.Rules;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SetCheckBox

class ConfigureRuleActionCopyIdeatoPipeline{
    public void run(def params){
        if(params."Pipeline"){
            SetText.run(ID:"//*[@id='move-idea-combobox']",Text:params."Pipeline")
            Click.run(ID:"//*[@id='f-combobox-list']//*[text()='${params."Pipeline"}']")
        }
        SetCheckBox.run(ID:"//*[@id='checkbox-appendExtraSubmissionQuestions']", Check:params."Append extra submission questions to description")
        SetCheckBox.run(ID:"//*[@id='checkbox-appendAdditionalInfo']", Check:params."Append Additional Info to description")
        SetCheckBox.run(ID:"//*[@id='checkbox-copyComments']", Check:params."Copy Comments")
        SetCheckBox.run(ID:"//*[@id='checkbox-copyVotes']", Check:params."Copy Votes")
        SetCheckBox.run(ID:"//*[@id='checkbox-copyAttachments']", Check:params."Copy Attachments")
        SetCheckBox.run(ID:"//*[@id='checkbox-linkIdeas']", Check:params."Link Ideas")
        
        sleep(2000)
        if(params.Action=="Save"){Click.run(ID:"//*[@data-test='modal-footer-submit']")}
        else{Click.run(ID:"//*[@data-test='modal-footer-cancel']")}
    }
}

