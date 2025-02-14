package actions.SetupEnterpriseExports;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem
import actions.selenium.Exists


class SetEnterpriseExportsForSiteWideTab{
    public void run(def params){
        
        SetupCommon.NavigateTab(Tab:"Exports",Section:"Site-Wide")
        
        SelectItem.run(ID:"(//*[@id='report-type-select'])[7]", "Visible Text": "Affiliate Summary")
        SelectItem.run(ID:"//*[@id='green_button_affiliate']/../..//select[@id='report-format-select']", "Visible Text":params."Format")
        Click.run(ID:"//*[@id='green_button_affiliate']")
        
        assert (Exists.run(ID:"//*[contains(@class, 'report-name') and starts-with(text(), 'Affiliate')]","Timeout":60)>0), "Error - Report was not generated"
        
    }
}