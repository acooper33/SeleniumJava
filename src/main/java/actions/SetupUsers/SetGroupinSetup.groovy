package actions.SetupUsers;

import actions.selenium.Click
import screens.SystemSetup.GroupCreationLocators
import screens.common.ModalButtonLocators
import org.openqa.selenium.By
import actions.selenium.SetText

class SetGroupinSetup{
    public void run(def params){
   
    GroupCreationLocators.run(params)
    ModalButtonLocators.run(params)     
    SetText.run(Text:params."Group Name","ID Type":"By", By:GroupCreationLocators.groupName,"Type of Clear":"Cut")
        if(params."Click on Reset Points"){
            if(params."Click on Reset Points"==true){
                Click.run("ID Type":"By", By:GroupCreationLocators.resetPoints)
                if(params."Reset Points Action"=="Reset Points"){
                    Click.run("ID Type":"By", By:ModalButtonLocators.confirmOKButton)
                } else {
                    Click.run("ID Type":"By", By:ModalButtonLocators.confirmCancelButton)
                }
            }
        }
        if(params."User"){
            params."User".split(",").eachWithIndex{ name, x ->
                if(params."Add or Remove".split(",")[x]=="Add"){
                    def user = params."User".split(",")
                	SetText.run(Text:params."Search User","ID Type":"By", By:GroupCreationLocators.memberSearchField,"Type of Clear":"Cut")
                	Click.run("ID Type":"By", By: GroupCreationLocators.getUserOnLeftRail(name), "Type of Click":"Javascript")                
                }
                else if(params."Add or Remove".split(",")[x]=="Remove"){
                    Click.run("ID Type":"By", By: GroupCreationLocators.getRemoveUserInRightRail(name))
                }
            }
        }
        if(params."Action"){
            if(params."Action" == "Update" || params."Action" =="Create Group"){Click.run("ID Type":"By", By:ModalButtonLocators.saveButton)}
            else if(params."Action" == "Cancel"){Click.run("ID Type":"By", By:ModalButtonLocators.cancelButton)}
        }
    } 
}