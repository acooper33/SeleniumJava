package actions.SetupExports;

import actions.common.SetupCommon
import actions.selenium.SelectItem
import actions.selenium.SetCheckBox
import actions.selenium.Click

class SetWebstormSetupExportsforCategoryTab{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Exports",Section:"Categories")
        
        SelectItem.run(ID:"(//*[@id='report-type-select'])[6]", "Visible Text":params."Report Options")
        SelectItem.run(ID:"//*[@id='green_button_category']/../..//*[@id='report-content']/*[@id='report-options-check']/*[@id='report-format-select']","Visible Text":params."Format")
		sleep(2000)
        //Click.run(ID:"//*[@id='green_button_login_history']")
        Click.run(ID:"//*[@id='green_button_category']")   
    }
}