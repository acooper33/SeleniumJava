package actions.Memo;

import actions.selenium.SendKeys
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SelectItem
//import actions.common.AppsCommon
import actions.selenium.SetFocus
import actions.selenium.SetReactTags


class MemoShareDialogSetParticipants{
    public void run(def params){
        
        //on userhome or in collab editor
        if(params."Click Share Button"==true){Click.run(ID:"//BUTTON[@id='f-share-dialog-btn']")}
       	//if(params."User(s)"){AppsCommon.MemoUserPickerAddWithPermissions("Field Name":"Shared with",User:params."User(s)","Permission":params."Permission (required)","Send Invite":params."Send Invite")}
        if(params."User(s)"){SetReactTags.setMemberTagsWithoutAddRemove("Field Name":"Shared with",User:params."User(s)","Permission":params."Permission (required)","Send Invite":params."Send Invite")}
        sleep(1000)
        if(params."Anyone With Link"){
            SetFocus.run(ID:"//DIV[contains(@class,'f-sharemodal-footer')]//DIV[@data-test='f-test-dropdown']")
        	Click.run(ID:"//DIV[contains(@class,'f-sharemodal-footer')]//DIV[@data-test='f-test-dropdown']")
            Click.run(ID:"//UL[contains(@class,'f-dropdown-options') and contains(@style,'display: block')]/LI/*[contains(.,'${params."Anyone With Link"}')]", "Handle Stale Element":true)
        }
        if(params."Action"=="Close"){Click.run(ID:"//*[contains(@class,'fractal-modal-header')]//DIV[@class='close-button']")}
    }
}