package actions.SetupIdeas;

import actions.selenium.SetCheckBox
import actions.selenium.Click
import actions.common.SetupCommon
import actions.selenium.SetText

class SetEnterpriseSetupIdeasIdeaSettingsTab{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Ideas",Section:"Idea Settings")
         SetCheckBox.run(ID:"//*[@id='CB_ENABLE_COMMENTING_COMPONENT']", Check:params."Unified Commenting Experience")
         if(params."Unified Commenting Experience"==true) {
         Click.run(ID:"//*[@data-test='modal-footer-submit']") }        
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_OUTCOMES_TAB']", Check:params."Enable Outcomes and Projections Tabs for Ideas")
        SetCheckBox.run(ID:"//*[@id='CB_PROMOTE_ONLY_WS']", Check:params."Show Promote Only")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_IDEA_TAGS_AUTOMATIC_SUBSCRIPTION']", Check:params."Enable Idea Tags Automatic Subscription")
        if(params."Custom Idea Code Prefix"){SetText.run(ID:"//*[@id='custom_idea_code']", Text:params."Custom Idea Code Prefix")} //will verify warning after clicking save
        SetCheckBox.run(ID:"//*[@id='CB_WS_CUSTOM_IDEA_CODE']", Check:params."Customized idea code on the activity level")
        Click.run(ID:"//*[@id='ideas_options_save_button']")
       // verify waring message for custom idea code prefix 
        if(params."Custom Idea Code Prefix"){
            sleep(2000)
            SetupCommon.VerifyModalWarningBody(Body:"We are actively adjusting the idea codes for your system, based on your input. This request will take a couple minutes to complete throughout the whole system, so stay tuned!")
        }
    }
}