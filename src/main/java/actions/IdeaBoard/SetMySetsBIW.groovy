package actions.IdeaBoard;

import actions.selenium.Click
import actions.selenium.SetText

class SetMySetsBIW{
    public void run(def params){
        if (params."Navigate to View My Sets" == true){
            Click.run(ID:"//*[contains(@class, 'f-best-idea-top-right-bar')]/BUTTON")
        }
        if(params."Create New Set"){
            Click.run(ID:"//BUTTON[contains(@class, 'f-add-set-btn')]")
            if(params."Name Your Set"){
                Click.run(ID:"//*[contains(@class,'titleHeaderSubmitFooter')]//*[@class='f-modal-body']//*[@id='f-best-idea-create-set-input']")
                SetText.run(ID:"//*[contains(@class,'titleHeaderSubmitFooter')]//*[@class='f-modal-body']//*[@id='f-best-idea-create-set-input']", Text:params."Name Your Set")
            }
            if(params.Action){Click.run(ID:"//*[contains(@class,'titleHeaderSubmitFooter')]//*[contains(@class,'f-footer')]/BUTTON[contains(@data-test,'${params.Action}')]")}
        }    
    }
}