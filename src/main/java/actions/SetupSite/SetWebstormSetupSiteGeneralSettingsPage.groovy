package actions.SetupSite;

import actions.common.SetupCommon
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem
import actions.selenium.SetText

class SetWebstormSetupSiteGeneralSettingsPage{
    public void run(def params){
        
        SetupCommon.NavigateTab(Tab:"Site",Section:"General Settings")
        sleep(2000)
        SetCheckBox.run(ID:"//*[@id='global-navigation-on-webstorm-checkbox']",Check:params."Enable Global Navigation on this Initiative")
        SetCheckBox.run(ID:"//*[contains(@id,'-team-site')]",Check:params."Enable Team Site View")
        SetCheckBox.run(ID:"//*[@id='CB_MY_PROFILE']",Check:params."Profiles")
        SetCheckBox.run(ID:"//*[@id='CB_USER_NETWORK_WS']",Check:params."User Networks")
        SetCheckBox.run(ID:"//*[@id='CB_PRIVATE_MESSAGING_WS']",Check:params."Private Messaging")
        //SetCheckBox.run(ID:"//*[@id='CB_ADMIN_WS']",Check:params."Dashboard for End Users")
        //SetCheckBox.run(ID:"//*[@id='CB_RSS_FEEDS']",Check:params."RSS Feeds")
        SetText.run(ID:"//*[@id='site_babysitter']",Text:params."Site baby-sitter")
        SelectItem.run(ID:"//*[@id='input_box setup_select']", "Visible Text":params."After Login Page")
        //SetCheckBox.run(ID:"//*[@id='OPT_EMAIL_THIS_PAGE']",Check:params."Enable Email this page")
        SetCheckBox.run(ID:"//*[@id='CB_DATE_FORMATTING']",Check:params."Enable Date Formatting")
 		SetText.run(ID:"//*[@id='DATE_FORMAT']",Text:params."Date Format")
        SetCheckBox.run(ID:"//*[@id='CB_REDIRECT_ENDED_CAMPAIGN_WS']",Check:params."Redirection URL")
        SetCheckBox.run(ID:"//*[@id='CB_WS_ENABLE_CHALLENGE_TOPIC']",Check:params."Display Home Page Welcome Header")
        if(params."Welcome Header"){
            if(params."Welcome Header" == "Welcome Header 1.0"){
                Click.run(ID:"//*[@id='CB_WELCOME_HEADER_1']")
            } else {
                Click.run(ID:"//*[@id='CB_WELCOME_HEADER_2']") 
            }
        }
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_SITE_HACK_ONBOARDING']",Check:params."Onboarding for Hackathon")
        SetCheckBox.run(ID:"//*[@id='CB_EMAIL_QUEUE_DAILY_ENABLE']",Check:params."Enable daily mail digest queue")
        SetCheckBox.run(ID:"//*[@id='CB_EMAIL_QUEUE_WEEKLY_ENABLE']",Check:params."Enable weekly mail digest queue")
        Click.run(ID:"//*[@id='components_save_button']")
        sleep(2000)    
    }
}