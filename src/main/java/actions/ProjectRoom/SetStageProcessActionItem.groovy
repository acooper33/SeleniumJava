package actions.ProjectRoom;

import actions.selenium.*

class SetStageProcessActionItem{
    public void run(def params){
        
        if(params."Is the Button Active"){
            if(params."Is the Button Active"==false){
                 assert Exists.run(ID:"//*[contains(@class,'f-btn-sm f-btn-primary') and @disabled]")==1, "Error - 'The button not disabled"
            } else {
                 assert Exists.run(ID:"//*[contains(@class,'f-btn-sm f-btn-primary') and @disabled]")==0, "the button is disabled"
            }
        }
        if(params."Action on Submit stage action item"){
            Click.run(ID:"//*[contains(@class,'f-btn-sm f-btn-primary')]")
            if(params."Action on Submit stage action item"=="Submit Stage"){
                Click.run(ID:"//*[@id='f-modal-submit']")
            } else {
                Click.run(ID:"//*[@data-test='modal-footer-cancel']")
            }
        }
        
    }
}