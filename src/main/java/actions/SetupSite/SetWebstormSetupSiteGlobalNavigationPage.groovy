package actions.SetupSite;

import actions.common.SetupCommon
import actions.selenium.SetCheckBox
import actions.selenium.Click

class SetWebstormSetupSiteGlobalNavigationPage{
    public void run(def params){
        
        SetupCommon.NavigateTab(Tab:"Site",Section:"Global Navigation")
        SetCheckBox.run(ID:"//*[@id='global-navigation-on-webstorm-checkbox']",Check:params."Enable Global Navigation")
        Click.run(ID:"//*[@id='global_nav_save_button']")  
        sleep(2000)
    }
}