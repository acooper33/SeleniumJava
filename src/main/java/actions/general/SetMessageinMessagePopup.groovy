package actions.general;

import actions.selenium.SetText
import actions.selenium.Click

class SetMessageinMessagePopup{
    public void run(def params){

        if (params."Recipient"){
            SetText.run(ID:"//*[@id='new_message_recipient-1']",Text:params."Recipient") 
            Click.run(ID:"//*[@class='gn_email_suggest_screen_name' and text()='${params."Recipient"}']","Type of Click":"Move to Element")
        }
        SetText.run(ID:"//*[@id='new_message_subject_1']",Text:params."Subject") 
        SetText.run(ID:"//*[@id='new_message_body_1']",Text:params."Message Body")
        if(params."Action"){
            Click.run(ID:"//*[@id='bi-modal-button']/*[text()='${params."Action"}']")
        }
    }
}