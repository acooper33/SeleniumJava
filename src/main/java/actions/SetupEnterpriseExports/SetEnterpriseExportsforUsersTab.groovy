package actions.SetupEnterpriseExports;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem
import actions.selenium.Exists


class SetEnterpriseExportsforUsersTab{
    public void run(def params){
        
        SetupCommon.NavigateTab(Tab:"Exports",Section:"Users")
        SelectItem.run(ID:"(//*[@id='report-type-select'])[3]", "Visible Text":params."Report Options")
        SetCheckBox.run(ID:"(//*[@id='report-option-profile'])[2]", Check:params."Include user profile data")
        SetCheckBox.run(ID:"//*[@id='report-option-groups']", Check:params."Include ALL user group")
        SelectItem.run(ID:"//*[@id='green_button_users']/../..//select[@id='report-format-select']", "Visible Text":params."Format")
        Click.run(ID:"//*[@id='green_button_users']")
        
        switch(params."Report Options"){
            case "User Activity": assert(Exists.run(ID:"//*[contains(@class, 'report-name') and starts-with(text(), 'User_activity')]","Timeout":60)>0),"Error - Report was not generated"; break
            case "user Group": assert(Exists.run(ID:"//*[contains(@class, 'report-name') and starts-with(text(), 'User_groups')]","Timeout":60)>0),"Error - Report was not generated"; break
        }
        
   }
}