package actions.SetupSite;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.*

class SetCommunitySetupSiteInfoTab{
    public void run(def params){
        
        SetupCommon.NavigateTab(Tab:"Site",Section:"Info")
        SetCheckBox.run(ID:"//*[@id='CB_SITE_INFO_ENT_PUBLIC']",Check:params."Make this Enterprise section public")
        SetText.run(ID:"//*[@id='campaign_identifier']",Text:params."Vanity URL")
        if(params."Verify Vanity URL Status"){
            assert Exists.run(ID:"//*[@id='campaign_identifier_status']/I[contains(@class,'_${params."Verify Vanity URL Status".toLowerCase()}')]") == 1,"Error - Vanity Status URL is not as expected"
        }
        Click.run(ID:"//*[@id='site_info_save_button']")  
        sleep(3000)
    }
}