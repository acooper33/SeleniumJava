package actions.SetupBI;

import actions.common.SetupCommon
import actions.selenium.Click

class ReindexAffiliateData{
    public void run(def params){
    	SetupCommon.NavigateTab(Tab:"BI Only",Section:"Search")
        Click.run(ID:"//*[@id='index_affiliate_data_button']")
        sleep(3000)
    }
}