package actions.SetupExports;

import actions.common.SetupCommon
import actions.selenium.SelectItem
import actions.selenium.SetCheckBox
import actions.selenium.Click

class SetWebstormSetupExportsforUsersTab{
    public void run(def params){
        
    	SetupCommon.NavigateTab(Tab:"Exports",Section:"Users")
        
        SelectItem.run(ID:"(//*[@id='report-type-select'])[3]", "Visible Text":params."Report Options")
        println("Include user profile data: ${params."Include User Profile Data"}")
        SetCheckBox.run(ID:"(//*[@id='report-option-profile'])[3]", Check:params."Include User Profile Data")
        sleep(2000)
        SelectItem.run(ID:"//*[@id='green_button' and contains(@style,'block')]/../..//*[@id='report-content']/*[@id='report-options-check']/*[@id='report-format-select']","Visible Text":params."Format")
        sleep(2000)
        Click.run(ID:"//*[@id='green_button' and contains(@style,'block')]//*[@id='generate-report-btn']")
    }
}