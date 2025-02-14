package actions.SetupIdeas;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem
import actions.selenium.ExecuteJavascript

class SetWebstormSetupIdeasforIdeastab{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Ideas",Section:"Ideas")

        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_IDEA_BOARDS']",Check:params."Idea Boards")
        SetCheckBox.run(ID:"//*[@id='CB_DISABLE_IDEA_SUBMISSION_WS']",Check:params."Idea Submission")
        //SetCheckBox.run(ID:"//*[@id='CB_WS_ENABLE_POST_IDEA_2']",Check:params."Post Idea 2.0")
        SetCheckBox.run(ID:"//*[@id='CB_ADD_IDEA_IMAGE_TO_IDEA_SUBMISSION_FORMS']",Check:params."Add Idea Image to Idea Submission Forms")

        if(params."Use Default Image"){Click.run(ID:"//*[@id='use_default_image_btn']")}
        
        SetCheckBox.run(ID:"//*[@id='CB_VIEW_IDEA_3']",Check:params."View Idea 3.0")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_PROMOTE_BTN']",Check:params."Improved promote button")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_DEV_TAB']",Check:params."Development tab")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_EDIT_DEV_FIELDS']",Check:params."Editable development fields")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_BUSINESS_IMPACT_TAB']",Check:params."Business impact tab")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_DISPLAY_IDEA_VIEWERS']",Check:params."Display idea viewers")
        
        SetCheckBox.run(ID:"//*[@id='CB_DUPLICATE_WS']",Check:params."Idea Duplicate Checker")
        SetCheckBox.run(ID:"//*[@id='CB_CHECK_ALL_COMMUNITIES_DUPLICATE_CHECKER']",Check:params."Check against other WebStorms under the same Community")
        SetCheckBox.run(ID:"//*[@id='CB_TAGS_WS']",Check:params."Idea Tags")
        SetCheckBox.run(ID:"//*[@id='CB_DISABLE_SUBMISSION_FORM_IDEA_ATTACHMENT']",Check:params."Attachments")
        SetCheckBox.run(ID:"//*[@id='CB_HIDE_IDEA_ON_SUBMIT']",Check:params."Hide ideas after submission")
        SetCheckBox.run(ID:"//*[@id='CB_RICH_TEXT_WS']",Check:params."Rich Text for Idea Description")
        SetCheckBox.run(ID:"//*[@id='CB_WS_DEPENDANT_FORM_QUESTION']",Check:params."Dependent Form Questions")
        SetCheckBox.run(ID:"//*[@id='CB_PRIVATE_ATTACHMENTS_WS']",Check:params."Private Attachments on Ideas")
        SetCheckBox.run(ID:"//*[@id='CB_WS_NEXT_PREV_BUTTONS']",Check:params."Next/Previous Buttons in View Idea Page")
        SetCheckBox.run(ID:"//*[@id='CB_IDEA_VIEW_COUNT']",Check:params."Show Idea View Count")
        SetCheckBox.run(ID:"//*[@id='CB_IDEA_OWNER_FEATURE_TOGGLE']",Check:params."Idea Owner")
        SetCheckBox.run(ID:"//*[@id='CB_MY_FAVORITES_WS']",Check:params."My Favorites")
        SetCheckBox.run(ID:"//*[@id='CB_TWEET_THIS_WS']",Check:params."Tweet This!")
        SetCheckBox.run(ID:"//*[@id='CB_IDEA_SUBSCRIPTION_WS']",Check:params."Category and Idea Subscription")
        SetCheckBox.run(ID:"//*[@id='CB_IDEA_SUBSCRIBE_OTHERS']",Check:params."Enable admin ability to subscribe other users")
        if(params."Campaign Specific Statuses"== true){
            SetCheckBox.run(ID:"//*[@id='CB_WS_USE_CAMPAIGN_SPECIFIC_STATUSES']",Check:params."Campaign Specific Statuses")
            Click.run(ID:"//*[@id='gen_mess_message']//*[text()='${params."Campiagn Statues Continue or Cancel"}']")        
        } else {SetCheckBox.run(ID:"//*[@id='CB_WS_USE_CAMPAIGN_SPECIFIC_STATUSES']",Check:params."Campaign Specific Statuses")}
        SetCheckBox.run(ID:"//*[@id='CB_EXPERTISE_ON_IDEA']",Check:params."Enable Expertise on Ideas")
        SetCheckBox.run(ID:"//*[@id='CB_EVALUATIONS_TAB_ON_VIEW_IDEA']",Check:params."Enable Evaluations Tab on View Idea 2.0")
        if(params."Custom Idea Code Prefix"){SetText.run(ID:"//*[@id='custom_idea_code']", Text:params."Custom Idea Code Prefix")}//also verifies the warning modal in the end
        SetText.run(ID:"//*[@id='submission_name_singular']", Text:params."Submission Name - Singular")
        SetText.run(ID:"//*[@id='submission_name_plural']", Text:params."Submission Name - Plural")
        if(params."Business impact timeframe"){
            if(params."Business impact timeframe" == "Quarterly"){
                Click.run(ID:"//*[@id='CB_WS_QUARTERLY_BUSINESS_IMPACT_QUARTERLY']")
            } else {Click.run(ID:"//*[@id='CB_WS_QUARTERLY_BUSINESS_IMPACT_YEARLY']")}
            
            if(params."Action for Business impact timeframe modal"){
                if(params."Action for Business impact timeframe modal" == "Continue"){
                    Click.run(ID:"//*[@data-test='modal-footer-submit']")
                } else {Click.run(ID:"//*[@data-test='modal-footer-cancel']")}
            }
        }
        SetCheckBox.run(ID:"//*[@id='CB_SUBMITTER_ACCESS_TO_BUSINESS_IMPACT_TAB']",Check:params."Submitter access to Business Impact Tab")

        //SetCheckBox.run(ID:"//*[@id='CB_USE_WS_ALIAS']",Check:params."Use WebStorm alias in URL")
        SelectItem.run(ID:"//*[@id='idea_url_format']","Visible Text":params."URL format for Ideas")
        SetCheckBox.run(ID:"//*[@id='CB_WS_ALLOW_IDEA_EDITING']",Check:params."Allow Idea Editing")
        SelectItem.run(ID:"//*[@id='ALLOW_IDEA_EDITING']","Visible Text":params."Allow Idea Editing to dropdown")
        if(params."Idea Submitter") {Click.run(ID:"//*[@id='enduser_edit_idea_options']/LABEL[contains(text(),'${params."Idea Submitter"}')]")}

        SetCheckBox.run(ID:"//*[@id='OPT_ALL_USERS_SEE_EXTRA_QUESTIONS_WS']",Check:params."Allow all users to see extra questions")
        SetCheckBox.run(ID:"//*[@id='OPT_HIDE_EXTRA_QUESTIONS_FROM_SUBMITTER_WS']",Check:params."Hide extra questions from submitter")
        SetCheckBox.run(ID:"//*[@id='OPT_CATEGORY_ALERTS_WS']",Check:params."Enable Category Alert Lists")
        SetCheckBox.run(ID:"//*[@id='OPT_HIDE_VOTE_HISTORY']",Check:params."Hide Vote History")
        SetCheckBox.run(ID:"//*[@id='WEIGHTED_VOTES_WS']",Check:params."Idea Ranking By Vote Multiplier")
        SetText.run(ID:"//*[@id='VOTE_MULTIPLIER']",Text:params."Redirect page to text")

        SetCheckBox.run(ID:"//*[@id='CB_ANON_OPTION']",Check:params."Anonymous Submission")
        SelectItem.run(ID:"//*[@id='ANONYMOUS_SUBMISSION_OPTIONS']","Visible Text":params."Anonymous Submission to dropdown")

        //SetCheckBox.run(ID:"//*[@id='CB_ENABLE_FEATURE_FIND_TEAMMATES']",Check:params."Enable Find Teammates", "Type of Click":"Javascript")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_FEATURE_FIND_TEAMMATES']",Check:params."Enable Find Teammates")

        if(params."Submit on Behalf"){
            if(params."Submit on Behalf"=="Group"){
                Click.run(ID:"//*[@id='group-radio-button']")
                Click.run(ID:"//*[@id='open-select-group']")
                SelectItem.run(ID:"//*[@id='groupDropdown']","Visible Text":params."Submit on Behalf group")}
            else if(params."Submit on Behalf"=="Admin"){ Click.run(ID:"//*[@id='submit_on_behalf_radio']/INPUT[starts-with(@value,'admin')]")}
            else {Click.run(ID:"//*[@id='submit_on_behalf_radio']/INPUT[starts-with(@value,'all')]")}
        }

        Click.run(ID:"//*[@id='ideas_save_button']")
        if(params."Custom Idea Code Prefix"){
            sleep(2000)
            SetupCommon.VerifyModalWarningBody(Body:"We are actively adjusting the idea codes for your system, based on your input. This request will take a couple minutes to complete throughout the whole system, so stay tuned!")
        }
		ExecuteJavascript.run(Code:"window.scrollTo(100, 0);")
    }
}