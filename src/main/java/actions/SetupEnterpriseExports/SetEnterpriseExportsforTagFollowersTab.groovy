package actions.SetupEnterpriseExports;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem
import actions.selenium.Exists

class SetEnterpriseExportsforTagFollowersTab{
    public void run(def params){
        
      	SetupCommon.NavigateTab(Tab:"Exports",Section:"Tag Followers")
        Click.run(ID:"(//*[@id='report-type-select'])[6]")
        SelectItem.run(ID:"(//*[@id='report-type-select'])[6]", Index:1)
        SelectItem.run(ID:"//*[@id='green_button_tag_followers']/../..//select[@id='report-format-select']", "Visible Text":params."Format")
        println("format: ${params."Format"}")
        Click.run(ID:"//*[@id='green_button_tag_followers']")
        
        assert (Exists.run(ID:"//*[contains(@class, 'report-name') and starts-with(text(), 'Tag_followers')]","Timeout":60)>0), "Error - Report was not generated"
               
        
    }
}