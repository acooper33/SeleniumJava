package actions.PipelineStepsView;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SetCheckBox
import actions.selenium.Exists
import actions.selenium.SetCombobox

class NewCopyIdeasinPipelineStepspage{
    public void run(def params){
        //may be used in Rules config modal as well
        if(Exists.run(ID:"//*[@id='actions_dropdown']")>0){
            Click.run(ID:"//*[@id='actions_dropdown']")
        }
        if(Exists.run(ID:"//*[@id='action-copy']")>0){
            Click.run(ID:"//*[@id='action-copy']")
        }
        //Click.run(ID:"//*[@id='action-copy']")
        if(params."Pipeline"){
            SetCombobox.run(ID:"//*[@id='copy-idea-combobox']", Option:params."Pipeline")
        }
        SetCheckBox.run(ID:"//*[@id='checkbox-appendExtraSubmissionQuestions']", Check:params."Append extra submission questions to description")
        SetCheckBox.run(ID:"//*[@id='checkbox-appendAdditionalInfo']", Check:params."Append Additional Info to description")
        SetCheckBox.run(ID:"//*[@id='checkbox-copyComments']", Check:params."Copy Comments")
        SetCheckBox.run(ID:"//*[@id='checkbox-copyVotes']", Check:params."Copy Votes")
        SetCheckBox.run(ID:"//*[@id='checkbox-linkIdeas']", Check:params."Link Ideas")
        SetCheckBox.run(ID:"//*[@id='checkbox-copyAttachments']", Check:params."Copy Attachments")
        SetCheckBox.run(ID:"//*[@id='checkbox-copyWhiteboardLink']", Check:params."Copy link to Whiteboard")
        sleep(2000)
        
        if(params."Missing Development Question Field"){
         assert Exists.run(ID:"//*[@class='f-missing-dev-question-warning-message-wrapper' and .='${params."Missing Development Question Field"} Development fields from this initiative are missing in the destination initiative. The data for these fields will not be moved. Learn more about Development Fields.']")==1, "Error - Development Field count is wrong"  
        }
        
        if(params.Action=="Copy Idea"){Click.run(ID:"//*[@data-test='modal-footer-submit']")}
        else{Click.run(ID:"//*[@data-test='modal-footer-cancel']")}

    }
}