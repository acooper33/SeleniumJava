package actions.ShareDialog;

import actions.common.AppsCommon
import actions.selenium.Click

class SetManagersinShareDialog{
    public void run(def params){
       
       if(params."Type of Manager"){
           Click.run(ID:"//*[contains(@data-test,'f-test-dropdown')]")
           Click.run(ID:"//*[contains(@class,'f-dropdown-options')]//*[text()='${params."Type of Manager"}']")
       }
       
        if(params."User"){
            AppsCommon.NewUserPickerAddRemoveInSetupWizard("Field Name":params."Field Name",User:params."User","Add or Remove":params."Users Add or Remove from Input Field")
        }
        
       if(params."Send Invite"){
           Click.run(ID:"//*[contains(@class,'f-send-invite') and .='${params."Send Invite"}']")
            //sleep(2000)
       }
        
       if(params."Managers to Remove"){
           params."Managers to Remove".split(',').eachWithIndex{manager, x ->
               def role = params."Managers to Remove Role".split(",")
               Click.run(ID:"//*[@class='f-member' and text()='${manager}']/../*[@class='f-member-admin-text' and text()= '${role[x]}']/..//*[@data-tooltip-content='Remove Manager']/I")
               sleep(2000)
            }
        } 
    }
}