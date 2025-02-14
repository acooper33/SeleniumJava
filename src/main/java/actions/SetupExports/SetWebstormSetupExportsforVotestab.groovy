package actions.SetupExports;

import actions.common.SetupCommon
import actions.selenium.SelectItem
import actions.selenium.SetCheckBox
import actions.selenium.Click

class SetWebstormSetupExportsforVotestab{
    public void run(def params){
        
        SetupCommon.NavigateTab(Tab:"Exports",Section:"Votes")
        
        SelectItem.run(ID:"(//*[@id='report-type-select'])[2]", "Visible Text":params."Report Options")
        SetCheckBox.run(ID:"(//*[@id='report-option-profile'])[2]", Check:params."Include user profile data")
        SelectItem.run(ID:"//*[@id='green_button']/../..//*[@id='report-content']/*[@id='report-options-check']/*[@id='report-format-select']","Visible Text":params."Format")
        sleep(2000)
        Click.run(ID:"//*[@id='green_button']")
   }
}