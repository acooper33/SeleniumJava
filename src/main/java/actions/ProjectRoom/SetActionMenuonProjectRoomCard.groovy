package actions.ProjectRoom;

import actions.selenium.*

class SetActionMenuonProjectRoomCard{
    public void run(def params){
        
        if(params."Option"){
			SetFocus.run(ID:"//*[contains(@class,'f-project-card f-userhomepage-card f-pr-card')]//*[@class='f-card-title' and text()='${params."Project Room Title"}']")
        	sleep(1000)
        	Click.run(ID:"//*[contains(@class,'f-project-card f-userhomepage-card f-pr-card')]//*[@class='f-card-title' and text()='${params."Project Room Title"}']/../..//I[contains(@class,'fas fa-ellipsis')]")
            Click.run(ID:"//UL[contains(@class,'f-dropdown-options') and contains(@style,'block')]/LI//SPAN[contains(.,'${params."Option"}')]")
        }
        if(params."Delete Action"){
            if(Exists.run(ID:"//*[@FOR='f-delete-room-hackathon-checkbox']")==1){
                Click.run(ID:"//*[contains(@class,'-modal-body')]/../DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper'))]/..//*[contains(text(),'I understand this will affect my')]/..")
            }
            if(params."Delete Action"=="Delete"){
                Click.run(ID:"//BUTTON[@id='clickToConfirmOkButton']")
                sleep(2000)
            } else if(params."Delete Action"=="Cancel"){
                Click.run(ID:"//BUTTON[@id='clickToConfirmCancelButton']")
            }
        }
    }
}
