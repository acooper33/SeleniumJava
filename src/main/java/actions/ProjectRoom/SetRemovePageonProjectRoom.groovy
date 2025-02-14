package actions.ProjectRoom;

import actions.selenium.*
import screens.common.ModalButtonLocators
import screens.Userhome.ProjectRoom.GateActionItemLocators

class SetRemovePageonProjectRoom{
    public void run(def params){
        
        ModalButtonLocators.run(params)
        GateActionItemLocators.run(params)
        if(params."Action"=="Cancel"){
            Click.run("ID Type":"By", By:ModalButtonLocators.cancelButton)
            //Click.run(ID:"//*[@data-test='modal-footer-cancel']")
        } else {
            if(Exists.run("ID Type":"By", By:GateActionItemLocators.deleteGateCheckbox)==1){
                Click.run("ID Type":"By", By:GateActionItemLocators.deleteGateCheckbox)
            } 
            Click.run("ID Type":"By", By:ModalButtonLocators.saveButton)
            //Click.run(ID:"//*[@data-test='modal-footer-submit']/*[text()='${params."Action"}']")
            sleep(2000)
        }        
    }
}