package actions.SetupSite;

import actions.selenium.SetCheckBox
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SelectItem
import actions.common.SetupCommon


class SetWebstormSetupSiteComponentsPage{
    public void run(def params){
        
        SetupCommon.NavigateTab(Tab:"Site",Section:"General Settings")
        sleep(2000)
        SetCheckBox.run(ID:"//*[@id='global-navigation-on-webstorm-checkbox']",Check:params."Enable Global Navigation on this Initiative")
        SetCheckBox.run(ID:"//*[@id='ENT_USER_NETWORK_WS']",Check:params."User Network")
        SetCheckBox.run(ID:"//*[@id='ENT_PRIVATE_MESSAGING_WS']",Check:params."Private Messaging")
        SetCheckBox.run(ID:"//*[@id='CB_ADMIN_WS']", Check:params."Dashboard for End Users")
        SelectItem.run(ID:"//*[@id='CB_LOGIN_PAGE']","Visible Text":params."After Login Page")
        SetCheckBox.run(ID:"//*[@id='CB_EMAIL_THIS_PAGE']",Check:params."Enable Email this page")
        SetCheckBox.run(ID:"//*[@id='CB_DATE_FORMATTING']",Check:params."Enable Date Formatting")
 		SetText.run(ID:"//*[@id='DATE_FORMAT']",Text:params."Date Format")
        SetCheckBox.run(ID:"//*[@id='CB_EMAIL_QUEUE_DAILY_ENABLE']",Check:params."Enable daily mail digest queue")
        SetCheckBox.run(ID:"//*[@id='CB_EMAIL_QUEUE_WEEKLY_ENABLE']",Check:params."Enable weekly mail digest queue")
        Click.run(ID:"//*[@id='components_save_button']")
        sleep(2000)
        
    }
}