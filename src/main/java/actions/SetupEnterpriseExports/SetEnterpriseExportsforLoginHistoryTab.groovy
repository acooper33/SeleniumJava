package actions.SetupEnterpriseExports;

import actions.common.SetupCommon
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem

class SetEnterpriseExportsforLoginHistoryTab{
    public void run(def params){
        
        SetupCommon.NavigateTab(Tab:"Exports",Section:"Login History")
        
        SelectItem.run(ID:"(//*[@id='report-type-select'])[4]", "Visible Text":params."Report Options")
        SetCheckBox.run(ID:"(//*[@id='report-option-profile'])[3]", Check:params."Include user profile data")
        SelectItem.run(ID:"//*[@id='green_button_login_history']/../..//select[@id='report-format-select']", "Visible Text":params."Format")
        Click.run(ID:"//*[@id='green_button_login_history']")
        
        //assert (Exists.run(ID:"//*[contains(@class, 'report-name') and starts-with(text(), 'Login_history')]","Timeout":60)>0), "Error - Report was not generated"
                        
    }
}