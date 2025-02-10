package actions.PipelineStepsView;

import actions.selenium.Click
import actions.selenium.SelectItem
import actions.selenium.SetCheckBox

class CopyIdeasinPipelineStepspage{
    public void run(def params){
        Click.run(ID:"//*[@id='actions_dropdown']")
        Click.run(ID:"//*[@id='action-copy']")
        SelectItem.run(ID:"//*[@id='copy_idea_dropdown']", "Visible Text":params.Pipeline)
        SetCheckBox.run(ID:"//*[@id='submission_questions']", Check:params."Append Extra Submission Questions")
        SetCheckBox.run(ID:"//*[@id='additional_info']", Check:params."Append Additional Info")
        SetCheckBox.run(ID:"//*[@id='copy_comments']", Check:params."Copy Comments")
        SetCheckBox.run(ID:"//*[@id='copy_attachments']", Check:params."Copy Attachments")
        SetCheckBox.run(ID:"//*[@id='copy_votes']", Check:params."Copy Votes")
        sleep(2000)
        if(params.Action=="Copy Idea"){Click.run(ID:"//*[@id='bi-modal-button']")}
        else{Click.run(ID:"//A[text()='Cancel']")}
    }
}