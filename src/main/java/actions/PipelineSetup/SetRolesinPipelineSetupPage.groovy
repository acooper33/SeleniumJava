package actions.PipelineSetup;

import actions.common.AppsCommon
import actions.selenium.Click
import actions.PipelineSetup.SetLeftSideTabInPipelineSetup

class SetRolesinPipelineSetupPage{
    public void run(def params){
        
        if(params."Navigate to Tab"==true){
            SetLeftSideTabInPipelineSetup.run(Tab:"Roles")
        }
                
        if(params."Type of Licensing Model" == "Standard Licensing Model"){
            AppsCommon.NewUserPickerAddRemove("Field Name":"Sponsor",User:params."Sponsor Name","Add or Remove":params."Sponsor Add or Remove")
            AppsCommon.NewUserPickerAddRemove("Field Name":"Idea Box Managers",User:params."Idea Box Managers","Add or Remove":params."Idea Box Managers Add or Remove")
            AppsCommon.NewUserPickerAddRemove("Field Name":params."Admin Field Name",User:params."Administrators","Add or Remove":params."Administrators Add or Remove")
        	AppsCommon.NewUserPickerAddRemove("Field Name":"Pipeline Moderators",User:params."Moderators","Add or Remove":params."Moderators Add or Remove")
        	AppsCommon.NewUserPickerAddRemove("Field Name":"Analysts",User:params."Analysts","Add or Remove":params."Analysts Add or Remove")
            if(params."Click Save" == true || params."Click Save" == null){
                Click.run(ID:"//*[@id='f-save-roles']")
            }        
        } else {
            AppsCommon.UserPickerAddRemove("Field Name":"Sponsor",User:params."Sponsor Name","Add or Remove":params."Sponsor Add or Remove")
        	AppsCommon.UserPickerAddRemove("Field Name":"Administrators",User:params."Administrators","Add or Remove":params."Administrators Add or Remove")
        	AppsCommon.UserPickerAddRemove("Field Name":"Moderators",User:params."Moderators","Add or Remove":params."Moderators Add or Remove")
        	AppsCommon.UserPickerAddRemove("Field Name":"Analysts",User:params."Analysts","Add or Remove":params."Analysts Add or Remove")
            if(params."Click Save" == true || params."Click Save" == null){
                Click.run(ID:"//*[@id='save-roles-btn']")
                sleep(6000)
            }    
        }
    }
}