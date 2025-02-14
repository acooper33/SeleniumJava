package actions.SetupUsers;

import actions.selenium.Exists
import actions.common.SetupCommon
import actions.selenium.Click

class VerifyInfoMessageonPeoplePillarandAdministratorTab{
    public void run(def params){
        
        if(params."Area"=="System Setup"){
            SetupCommon.NavigateTab(Tab:"Users",Section:"Administrators")
        } else if(params."Area"=="Idea Box Community Setup"){
            SetupCommon.NavigateTab(Tab:"Users",Section:"Managers")
        }
        
        if(params."Share Dialog"==true){
            Click.run(ID:"//*[@class='f-admin-info-box']//*[@class='f-collapsible-link']")
        }
        
       if(params."Info Message Exists"==true){
            assert Exists.run(ID:"//*[contains(@class,'f-info-body-wrapper') and contains(.,'${params."Info Message"}')]")==1, "Error - 'Info Message not displayed"
        } else{
            assert Exists.run(ID:"//*[contains(@class,'f-info-body-wrapper') and contains(.,'${params."Info Message"}')]")==0, "Error - 'Info message displayed when it shouldnt be"            
        }
    }
}