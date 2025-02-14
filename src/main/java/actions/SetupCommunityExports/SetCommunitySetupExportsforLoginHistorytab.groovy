package actions.SetupCommunityExports;

import actions.common.SetupCommon
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem

class SetCommunitySetupExportsforLoginHistorytab{
    public void run(def params){
   
        SetupCommon.NavigateTab(Tab:"Exports",Section:"Login")
        SelectItem.run(ID:"(//*[@id='report-type-select'])[4]", "Visible Text":params."Report Options")
        SetCheckBox.run(ID:"(//*[@id='report-option-profile'])[4]", Check:params."Include user profile data")
        SelectItem.run(ID:"//*[@id='green_button_login_history']/../..//select[@id='report-format-select']", "Visible Text":params."Format")
        Click.run(ID:"//*[@id='green_button_login_history']")
                  
    }
}