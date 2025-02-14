package actions.SetupSite;

import actions.selenium.SetCheckBox
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SelectItem
import actions.common.SetupCommon

class SetEnterpriseSetupSiteComponentsPage{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Site",Section:"General Settings")
        sleep(2000)
        SelectItem.run(ID:"//*[@id='home_page']", "Visible Text":params."Set Home Page to")
        SetCheckBox.run(ID:"//*[@id='ENT_USER_NETWORK_WS']",Check:params."User Network")
        SetCheckBox.run(ID:"//*[@id='ENT_PRIVATE_MESSAGING_WS']",Check:params."Private Messaging")
        SetText.run(ID:"//*[@id='ent_contact_email']",Text:params."Contact Email")
        SetText.run(ID:"//*[@id='ent_contact_name']",Text:params."Contact Name")
        SetCheckBox.run(ID:"//*[@id='CB_EMAIL_THIS_PAGE']",Check:params."Enable Email this page")
        SetCheckBox.run(ID:"//*[@id='CB_DATE_FORMATTING']",Check:params."Enable Date Formatting")
 		SetText.run(ID:"//*[@id='DATE_FORMAT']",Text:params."Date Format")
        SelectItem.run(ID:"//*[@id='timezone']", "Visible Text":params."Time Zone")
        SelectItem.run(ID:"//*[@id='ENT_HOURLY_TIME_FORMAT']", "Visible Text":params."Time Format")
        SelectItem.run(ID:"//*[@id='currency_setting']", "Visible Text":params."Currency")
        SetCheckBox.run(ID:"//*[@id='CB_EMAIL_QUEUE_DAILY_ENABLE']",Check:params."Enable daily mail digest queue")
        SetCheckBox.run(ID:"//*[@id='CB_EMAIL_QUEUE_WEEKLY_ENABLE']",Check:params."Enable weekly mail digest queue")
        SetCheckBox.run(ID:"//*[@id='CB_ENT_USERS_BLOG_POST']",Check:params."Allow users to Post to Enterprise Blog")
        SetCheckBox.run(ID:"//*[@id='CB_CANVASES']", Check:params."Enable Whiteboards")
        SetCheckBox.run(ID:"//*[@id='CB_IMAGE_CREATION_WITH_AI']", Check:params."Image Generation")
        SetCheckBox.run(ID:"//*[@id='CB_AI_IN_WHITEBOARDS']", Check:params."Whiteboard, AI Assist")
        Click.run(ID:"//*[@id='site_components_save_button']")
        sleep(2000)
    }
}