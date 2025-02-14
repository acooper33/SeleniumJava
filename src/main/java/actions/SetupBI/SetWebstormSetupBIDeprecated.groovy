package actions.SetupBI;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox

class SetWebstormSetupBIDeprecated{
    public void run(def params){
         SetupCommon.NavigateTab(Tab:"BI",Section:"Deprecated")
        
        SetCheckBox.run(ID:"//*[@id='CB_ADMIN_WS']",Check:params."Dashboard for End Users")
        SetCheckBox.run(ID:"//*[@id='CB_RSS_FEEDS']",Check:params."RSS Feeds")
        SetCheckBox.run(ID:"//*[@id='CB_IDEA_BOARDS_CARDS_FRACTAL_V2']",Check:params."New Idea Card Design")
        SetCheckBox.run(ID:"//*[@id='OPT_EMAIL_THIS_PAGE']",Check:params."Enable Email this page")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_ENTERPRISE_NAV_WS']",Check:params."Enterprise Home in Initiative Navigation")
        SetCheckBox.run(ID:"(//*[@id='CB_LIMIT_COLLAB_TO_MODERATORS_WS'])", Check:params."Limit Collaboration to Moderators")
        SetCheckBox.run(ID:"//*[@id='CB_WS_ENABLE_POST_IDEA_2']",Check:params."Post Idea 2.0")
        SetCheckBox.run(ID:"//*[@id='CB_USE_WS_ALIAS']",Check:params."Use alias in URL")
        SetCheckBox.run(ID:"//*[@id='CB_WS_ADMIN_QUESTIONS']",Check:params."Enable Additional Info Fields")
        
        Click.run(ID:"//*[@id='bi_only_deprecated_save_button']")
    
    }
}