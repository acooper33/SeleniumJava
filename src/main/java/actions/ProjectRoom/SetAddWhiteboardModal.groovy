package actions.ProjectRoom;

import actions.selenium.SetReactModal
import actions.selenium.*

class SetAddWhiteboardModal{
    public void run(def params){
        if(params."Existing or New"){
            SetReactModal.setModalRadioButtonWithInput("Section xPath":"//DIV[contains(@class,'f-add-whiteboard')]","Radio Option":params."Existing or New", "Title":params."Title")
        }
        if(params."Action"){
            SetReactModal.setModalActionButton("Action":params.Action)  
        }
        sleep(5000)
    }
}