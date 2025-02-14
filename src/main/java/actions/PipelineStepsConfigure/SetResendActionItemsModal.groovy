package actions.PipelineStepsConfigure;

import actions.selenium.SetCheckBox
import actions.selenium.Click

class SetResendActionItemsModal{
    public void run(def params){
        
        if(params."Dont show this message again"){
            if(params."Dont show this message again" == "TRUE"){Click.run(ID:"//*[@class='f-checkbox']/*[not(contains(@class,'f-checkbox-checked'))]//*[@id='f-resend-action-item-checkbox']/..","Type of Click":"Move to Element")}
            if(params."Dont show this message again" == "FALSE"){Click.run(ID:"//*[@class='f-checkbox']/*[contains(@class,'f-checkbox-checked')]//*[@id='f-resend-action-item-checkbox']/..","Type of Click":"Move to Element")}
        }
        if(params."Action"){
            if(params."Action"=="Continue"){
                Click.run(ID:"//*[@id='f-modal-submit']")
            } else {
                Click.run(ID:"//*[@data-test='modal-footer-cancel']")
            }            
        }        
    }
}