package actions.SetupUsers;

import actions.common.AppsCommon
import actions.common.SetupCommon
import actions.selenium.Click

class SetCommunityAdmininCommunitySetup{
    public void run(def params){
        
        if(params."Field Name" == "Idea Box Managers"){
            SetupCommon.NavigateTab(Tab:"Users",Section:"Managers")
        } else {
            SetupCommon.NavigateTab(Tab:"Users",Section:"Administrators")
        }
        AppsCommon.NewUserPickerAddRemoveInSetupWizard("Field Name":params."Field Name",User:params."Community Admin or Idea Box Manager","Add or Remove":params."Add or Remove")
        Click.run(ID:"//*[@id='f-save-roles']")
    }
}