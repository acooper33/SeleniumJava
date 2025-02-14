package actions.IdeaBoard;

import actions.selenium.SetText
import actions.selenium.Click

class SetPromoteorDemoteReasoninIdeaBoards{
    public void run(def params){
        
        SetText.run(ID:"//*[@id='voting-modal-input']", Text:params."Enter Reason")
        if(params."Action"){
            if(params.Action=="Promote" || params.Action=="Demote"){
                Click.run(ID:"//*[@id='clickToConfirmOkButton' and .='${params."Action"}']")
            } else if(params.Action=="Cancel"){
                Click.run(ID:"//*[@id='clickToConfirmCancelButton']")
            } else {
                Click.run(ID:"//*[contains(@class,'f-close-button')]")
            }
        }
    }
}