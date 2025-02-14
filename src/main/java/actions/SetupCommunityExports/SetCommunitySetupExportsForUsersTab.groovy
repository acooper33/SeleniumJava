package actions.SetupCommunityExports;

import actions.common.SetupCommon
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem

class SetCommunitySetupExportsForUsersTab{
    public void run(def params){
        
   		SetupCommon.NavigateTab(Tab:"Exports",Section:"Users")
        SelectItem.run(ID:"(//*[@id='report-type-select'])[3]", "Visible Text":params."Report Options")
        SetCheckBox.run(ID:"//*[contains(@class,'report-data-option options-user-details')]//INPUT", Check:params."Include user profile data")
        SetCheckBox.run(ID:"//*[contains(@class,'report-data-option options-user-groups')]//INPUT", Check:params."Include ALL user group")
        SelectItem.run(ID:"//*[@id='green_button' and contains(@style,'block')]/../../..//select[@id='report-format-select']", "Visible Text":params."Format")
        Click.run(ID:"//*[@id='green_button' and contains(@style,'block')]")
   }
}