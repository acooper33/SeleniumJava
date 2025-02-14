package actions.Memo;

import actions.selenium.Click
import actions.common.AppsCommon

class MemoShareDialogUpdateRemoveParticipants{
    public void run(def params){
        
        //on userhome or in collab editor
        if(params."Click Share Button"==true){Click.run(ID:"//BUTTON[@id='f-share-dialog-btn']")}
        if(params."User(s)"){AppsCommon.MemoUserPickerRemoveUpdatePermissions(User:params."User(s)","Option":params."Option(s)")}
       	if(params."Action"=="Close"){Click.run(ID:"//*[contains(@class,'fractal-modal-header')]//DIV[@class='close-button']")}
    }
}