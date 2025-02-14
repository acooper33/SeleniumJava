package actions.SetupEnterpriseExports;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem
import actions.selenium.Exists
import actions.selenium.Click

class SetEnterpriseExportsforSearchHistoryTab{
    public void run(def params){
        
        SetupCommon.NavigateTab(Tab:"Exports",Section:"Search History")
        
        SelectItem.run(ID:"(//*[@id='report-type-select'])[5]", "Visible Text":params."Report Options")
        SetCheckBox.run(ID:"(//*[@class='report-data-option options-search-history-details']//*[@id='report-option-profile'])", Check:params."Include user profile data")
        SelectItem.run(ID:"//*[@id='green_button_search_history']/../..//select[@id='report-format-select']", "Visible Text":params."Format")
        Click.run(ID:"//*[@id='green_button_search_history']")
        
        switch(params."Report Options"){
            case "Search History": assert (Exists.run(ID:"//*[contains(@class, 'report-name') and starts-with(text(), 'Search_history')]","Timeout":60)>0), "Error - Report was not generated"; break
            case "Search Term Frequency": assert (Exists.run(ID:"//*[contains(@class, 'report-name') and starts-with(text(), 'Search_term_frequency')]","Timeout":60)>0), "Error - Report was not generated"; break
        }
            
    }
}