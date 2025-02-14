package actions.ViewIdea30;

import actions.selenium.Click

class SetRemoveAttachmentinViewIdea3Page{
    public void run(def params){
        
         if(params."Action"){
            if(params."Action"=="Remove"){
                Click.run(ID:"//BUTTON[@id='clickToConfirmOkButton']")
            } else if(params."Action"=="Cancel"){
                Click.run(ID:"//BUTTON[@id='clickToConfirmCancelButton']")
            }
        }
    }
}