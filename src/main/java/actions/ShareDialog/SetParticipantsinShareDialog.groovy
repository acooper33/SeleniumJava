package actions.ShareDialog;

import actions.common.AppsCommon
import actions.selenium.Click
import actions.selenium.SetFocus
import actions.selenium.SendKeys
import java.nio.file.Paths
import actions.selenium.SetText
import actions.selenium.SetReactTags

class SetParticipantsinShareDialog{
    public void run(def params){
        def os = System.getProperty("os.name").toLowerCase();
        if(params."Participants"){
            SetReactTags.setMemberTagsWithAddRemove("Field Name":"Invite Participants",User:params."Participants","Add or Remove":params."Participants Add or Remove from Input Field")

            //AppsCommon.NewUserPickerAddRemoveInSetupWizard("Field Name":"Invite Participants",User:params."Participants","Add or Remove":params."Participants Add or Remove from Input Field")
        }        
        if(params."Import Group File"){
            def fileName
            SetFocus.run(ID:"//*[contains(@class,'f-justified-footer')]")
            sleep(500)
            Click.run(ID:"//*[contains(@class,'f-or-import-link')]")
            if(os.contains("nix") || os.contains("nux")||os.contains("aix")){
            	fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${params."Import Group File"}"
           	}else{
                fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."Import Group File"}"
            }
            SendKeys.run(ID:"//*[@id='f-file-upload']",Text:fileName)
            sleep(2000)
            SetText.run(ID:"//*[@id='f-import-group-name']",Text:params."Import Group Name")
            Click.run(ID:"//*[@class='f-import-btn-container']//*[text()='${params."Import Group Action"}']")
        }        
        if(params."Send Invite"==true){
            Click.run(ID:"//*[contains(@class,'f-send-invite') and .='Send Invite']")
            //sleep(2000)
        }
        if(params."Participants to Remove"){
            params."Participants to Remove".split(',').each{participant -> 
            Click.run(ID:"//*[@class='f-member' and text()='${participant}']/..//*[@data-tooltip-content='Remove user']/I", "Handle Stale Element":true)
            }
        } 
        if(params."Groups to Remove"){
            params."Groups to Remove".split(',').each{group ->
            Click.run(ID:"//*[@class='f-member']//*[.='${group}']/../..//*[@data-tooltip-content='Remove group']/I")
            }
        } 
    }
}