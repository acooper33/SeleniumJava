package actions.PipelineStepsView;

import actions.selenium.Click
import actions.selenium.SetCheckBox

class SetDeleteIdea{
    public void run(def params){
        
        SetCheckBox.run(ID:"//*[contains(@class,'f-confirm-warning-model-checkbox')]//INPUT/..",Check: params."I understand")
        
        if(params."Action"){
            if(params.Action=="Cancel"){
                Click.run(ID:"//*[contains(text(),'Delete')]/../..//*[@data-test='modal-footer-cancel']")
            } else if(params.Action=="Close"){
            	Click.run(ID:"//*[contains(text(),'Delete')]/..//*[@data-tooltip-id='modal-close']")
            } else {
            	Click.run(ID:"//*[contains(text(),'Delete')]/../..//*[@data-test='modal-footer-submit']/*[text()='${params."Action"}']")
                sleep(2000)
            }
        }
    }
}
