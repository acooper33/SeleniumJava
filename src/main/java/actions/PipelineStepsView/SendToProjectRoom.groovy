package actions.PipelineStepsView;

import actions.selenium.SetReactModal
import actions.selenium.*
    
class SendToProjectRoom{
    public void run(def params){
        if (params."From the Actions Menu"==null || params."From the Actions Menu"==true){ 
            Click.run(ID:"//*[@id='actions_dropdown']")
        	Click.run(ID:"//*[@id='action-send-to-pr']")
            sleep(1000)
        }
        if(params."Existing or New"){
            SetReactModal.setModalRadioButtonWithInput("Section xPath":"//DIV[contains(@class,'f-add-sendProjectRoom')]/..","Radio Option":params."Existing or New", "Title":params."Title")
        }
        if(params."Action"){
            SetReactModal.setModalActionButton("Modal xPath":"//DIV[contains(@class,'f-add-sendProjectRoom')]/../..", "Action":params.Action)  
        }
        if(params."Wait"==null || params."Wait"==true){
         	sleep(10000)   
        }
    }
}