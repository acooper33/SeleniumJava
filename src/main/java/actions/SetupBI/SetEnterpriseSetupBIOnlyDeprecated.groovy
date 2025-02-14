package actions.SetupBI;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox

class SetEnterpriseSetupBIOnlyDeprecated{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"BI Only",Section:"Deprecated")
        
        
        SetCheckBox.run(ID:"//*[@id='CB_RULES_ENGINE_IMPROVEMENTS']", Check:params."Rules Engine Updated UI")
        
        
        Click.run(ID:"//*[@id='bi_only_deprecated_save_button']")
    
    }
    
}