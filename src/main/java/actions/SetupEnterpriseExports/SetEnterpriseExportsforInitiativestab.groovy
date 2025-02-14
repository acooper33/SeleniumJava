package actions.SetupEnterpriseExports;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem
import actions.selenium.Exists

class SetEnterpriseExportsforInitiativestab{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Exports",Section:"Initiatives")
        
        SelectItem.run(ID:"//*[@id='report-type-select']", "Visible Text":params."Report Options")                
        SetCheckBox.run(ID:"//*[@id='report-option-profile']", Check:params."Include user profile data")
        SelectItem.run(ID:"//*[@id='report-format-select']", "Visible Text":params."Format")
        Click.run(ID:"//*[@id='green_button']")
        
        sleep(5000)
    }
}