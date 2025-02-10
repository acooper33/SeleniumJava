package actions.Whiteboards;

import actions.selenium.SendKeys
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SelectItem
import actions.common.AppsCommon

class WhiteboardTemplateShareDialogSetParticipants{
    public void run(def params){
        if(params."Click Share Button"==true){
            Click.run(ID:"//*[@class='f-canvas-top-bar-right']/BUTTON[@id='f-share-dialog-btn']")
        } 
        if(params."User(s)"){
			AppsCommon.NewUserPickerAddRemoveInSetupWizard(
            	"Field Name":"",
                "User":params."User(s)",
                "Add or Remove":params."Add or Remove",                
            )
            /*AppsCommon.MemoUserPickerAddWithPermissions(
                "Field Name":"",
                "User":params."User(s)",
                "Send Invite":params."Send Invite"
            )*/
        }
        if(params."Send Invite"==true){Click.run(ID:"//*[contains(@class,'f-send-invite') and .='Send Invite']")}
        if(params."Everyone in this system (it's ON by default)"== "ON"){Click.run(ID:"//DIV[contains(@class, 'f-toggle-off')]")} 
        if(params."Everyone in this system (it's ON by default)"== "OFF"){Click.run(ID:"//DIV[contains(@class, 'f-toggle-on')]")}        
        if(params."Everyone in this system can ... (can use by default)"){
            Click.run(ID:"//INPUT[@id='f-member-share-toggle']/..//DIV[contains(@class,'fractal-dropdown')]//*[contains(@class,'f-wb-share-options')]", "Type of Click":"Javascript")
            Click.run(ID:"//INPUT[@ID='f-member-share-toggle']/..//DIV[contains(@class,'fractal-dropdown')]//UL[contains(@class,'f-dropdown-options')]/LI/DIV[contains(.,'${params."Everyone in this system can ... (can use by default)"}')]")
        }
        if(params."Action"=="Close"){Click.run(ID:"//*[contains(@class,'fractal-modal-header')]//DIV[@class='close-button']")}
    }
}