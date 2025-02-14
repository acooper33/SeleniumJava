package actions.NGAViewIdea;

import actions.selenium.Click
import actions.selenium.SelectItem
import actions.selenium.SetText
import actions.selenium.SetCheckBox

class ChangeIdeaStatusinNGAViewIdea{
    public void run(def params){
        Click.run(ID:"//*[@id='idea-status-edit']", "Type of Click":"Javascript")
        SelectItem.run(ID:"//*[@id='status-list-dropdown']", "Visible Text": params."New Idea Status")
        SetCheckBox.run(ID:"//*[@id='add-change-reason-checkbox']", Check: params."Add Status Change Reason")
        sleep(1000)
        SetText.run(Text:params."Add Status Change Reason Text",ID:"//*[@id='status-reason-comment-textarea']")
        SetCheckBox.run(ID:"//*[@id='email-reason-text-checkbox']",Check:params."Include in Email Notification")
        SetCheckBox.run(ID:"//*[@id='idea-comment-checkbox']",Check:params."Include in Comment")
        
        if(params.Action=="Change Status"){Click.run(ID:"//*[@class='green_btn_container']/*[text()='Change Status']")}
        else{Click.run(ID:"//*[@id='change-status-popup']/DIV[1]/DIV[1]/DIV[1]/DIV[3]/A[1]")}
        sleep(3000)
    }
}