package actions.general;

import actions.selenium.SetText
import actions.selenium.Click

class SetMessageInMessagePopUpOnIdeaBoards{
    public void run(def params){

        SetText.run(ID:"//INPUT[@class='f-message-subject']",Text:params."Subject")
        SetText.run(ID:"//TEXTAREA[@class='f-message-body']",Text:params."Message Body")
        if(params."Action"){
            Click.run(ID:"//TEXTAREA[@class='f-message-body']/../../../..//BUTTON[@id='f-modal-submit']")
        }
    }
}