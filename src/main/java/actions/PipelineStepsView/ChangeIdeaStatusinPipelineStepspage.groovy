package actions.PipelineStepsView;

import actions.selenium.Click
import actions.selenium.SelectItem
import actions.selenium.SetText
import actions.selenium.SetCheckBox

class ChangeIdeaStatusinPipelineStepspage{
    public void run(def params){
        Click.run(ID:"//*[@id='actions_dropdown']")
        Click.run(ID:"//*[@id='action-status']")
        
        SelectItem.run(ID:"//*[@id='status-list-dropdown']","Visible Text":params."Status")
        SetCheckBox.run(ID:"//*[@id='add-change-reason-checkbox']",Check:params."Add Status Change Reason")
        sleep(1000)
        SetText.run(Text:params."Add Status Change Reason Text",ID:"//*[@id='status-reason-comment-textarea']")
        SetCheckBox.run(ID:"//*[@id='email-reason-text-checkbox']",Check:params."Include in Email Notification")
        SetCheckBox.run(ID:"//*[@id='idea-comment-checkbox']",Check:params."Include in Comment")
        SetCheckBox.run(ID:"//*[@id='admin-comment-checkbox']",Check:params."Add as an Admin Comment")
        
        if(params.Action=="Change Status"){Click.run(ID:"//*[@class='green_btn_container']/*[text()='Change Status']")}
        else{Click.run(ID:"//*[@id='change-status-popup']/DIV[1]/DIV[1]/DIV[1]/DIV[3]/A[1]")}
        sleep(3000)
    }
}