package actions.SetupSite;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem
import actions.selenium.ExplicitWait

class SetEnterpriseSetupSiteUserHomepage{
    public void run(def params){
        
        SetupCommon.NavigateTab(Tab:"Site",Section:"User Homepage")
        sleep(4000)
        if(params."User Homepage options"){
            if(params."User Homepage options"=="Member Landing Page"){
                Click.run(ID:"//*[@id='landing_page']")
            } else {Click.run(ID:"//*[@id='user_home']")}
        }
        
         SetCheckBox.run(ID:"//*[@id='CB_FEATURE_ROUTE_USERS_TO_MEMO_TEAM_SITE']",Check:params."Route users to Memo Team Site")
        
        //Tab
        SetCheckBox.run(ID:"//*[@id='CB_FEATURE_USER_HOMEPAGE_TAB_HIGHLIGHTS']",Check:params."Highlights")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_END_USER_ONBOARDING_PANEL_ON_HIGHLIGHTS_PAGE']",Check:params."Onboarding Panel")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_ADMINISTRATOR_MESSAGE_ON_HIGHLIGHTS_PAGE']",Check:params."Administrator Message on Highlights page")
        SetCheckBox.run(ID:"//*[@id='CB_FEATURE_USER_HOMEPAGE_TAB_ACTION_ITEMS']",Check:params."My Action Items")
        
        //featured activity
        SetCheckBox.run(ID:"//*[@id='CB_USER_HOMEPAGE_FEATURED_ACTIVITY']",Check:params."Featured Activity")
        if (params."Featured Activity Title(s)"){
            params."Featured Activity Title(s)".split(',').eachWithIndex{name, x ->
                if(params."Featured Activity Title(s) Add or Remove".split(',')[x]=="Add"){
                	Click.run(ID:"//INPUT[@id='create-submission-combobox']")
                    SetText.run(ID:"//INPUT[@id='create-submission-combobox']",Text:name, "Type of Clear":"None")
                    sleep(1000)
                    Click.run(ID:"//*[@id='f-combobox-v2-list']//DIV[contains(@class,'f-combobox-v2-list-item') and contains(text(), '${name}')]")
                }
                else{
                    Click.run(ID:"//*[@id='user_homepage_featured_activity']//DIV[contains(@class,'f-combobox-v2-token') and contains(text(),'${name}')]/BUTTON")
                }
            }
        }
        SetCheckBox.run(ID:"//*[@id='CB_FEATURE_USER_HOMEPAGE_TAB_ACTIVITIES']",Check:params."Activities")
        SetCheckBox.run(ID:"//*[@id='CB_FEATURE_USER_HOMEPAGE_TAB_SPARKS']",Check:params."My Ideas")
        SetCheckBox.run(ID:"//*[@id='CB_FEATURE_USER_HOMEPAGE_TAB_SUBMISSIONS']",Check:params."Submissions")
        SetCheckBox.run(ID:"//*[@id='CB_FEATURE_USER_HOMEPAGE_TAB_PROJECTS']",Check:params."Projects")
        
        //Additional Options
        SetCheckBox.run(ID:"//*[@id='CB_FEATURE_USER_HOMEPAGE_HELPFUL_LINKS']",Check:params."Helpful Links")
        
        //User Metrics
        SetCheckBox.run(ID:"//*[@id='CB_USER_HOME_METRICS_MY_IDEAS']",Check:params."User Metrics My Ideas")
        SetCheckBox.run(ID:"//*[@id='CB_USER_HOME_METRICS_SUBMISSIONS']",Check:params."User Metrics Submissions")
        SetCheckBox.run(ID:"//*[@id='CB_USER_HOME_METRICS_ACTIVITIES']",Check:params."User Metrics Activities")
        SetCheckBox.run(ID:"//*[@id='CB_USER_HOME_METRICS_SUBMISSION_VIEWS']",Check:params."User Metrics Submission Views")
        SetCheckBox.run(ID:"//*[@id='CB_USER_HOME_METRICS_COLLABORATORS']",Check:params."User Metrics Collaborators")
        SetCheckBox.run(ID:"//*[@id='CB_USER_HOME_METRICS_PROJECTS']",Check:params."User Metrics Projects")
        SetCheckBox.run(ID:"//*[@id='CB_USER_HOME_METRICS_BUSINESS_IMPACT']",Check:params."User Metrics Business Impact")
        
        //My Ideas
        SetCheckBox.run(ID:"//*[@id='CB_FEATURE_USER_HOMEPAGE_VOICE_SUBMISSION']",Check:params."My Ideas Voice Capture")
        SetCheckBox.run(ID:"//*[@id='CB_FEATURE_USER_HOMEPAGE_EMAIL_SUBMISSION']",Check:params."My Ideas Email Capture")
        SetText.run(ID:"//*[@id='mail_address']",Text:params."Mail Address")
        SelectItem.run(ID:"//*[@id='mail_host']","Visible Text":params."Mail Host")
        
        SetText.run(Text:params."Idea Name Singular",ID:"//*[@id='spark_name_singular']","Type of Clear":"Cut")
        SetText.run(Text:params."Idea Name Plural",ID:"//*[@id='spark_name_plural']","Type of Clear":"Cut")
        
        Click.run(ID:"//*[@id='user_homepage_save_button']", "Type of Click":"Javascript")  
        ExplicitWait.run(ID:"//*[@id='user_homepage_spinner' and contains(@style,'display: none;')]")
    }
}