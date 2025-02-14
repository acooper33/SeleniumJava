package actions.SetupAccess;

import actions.common.SetupCommon
import actions.selenium.Click
import actions.selenium.SetCheckBox

class SetWebstormSetupforAccessAuthentication{
    public void run(def params){
        
        SetupCommon.NavigateTab(Tab:"Access",Section:"Authentication")
        SetCheckBox.run(ID:"//*[@id='DISABLE_BI_AUTH']",Check:params."Enable Brightidea Login")
        SetCheckBox.run(ID:"//*[@name='OPT_CLOSED_REGISTRATION_WS']",Check:params."Enable Registration")
        Click.run(ID:"//*[@id='auth_selection_save_button']")
    }
}