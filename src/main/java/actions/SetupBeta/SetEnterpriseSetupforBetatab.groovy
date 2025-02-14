package actions.SetupBeta;

import actions.common.SetupCommon
import actions.selenium.Click
import actions.selenium.SetCheckBox

class SetEnterpriseSetupforBetatab{
    public void run(def params){

        SetupCommon.NavigateTab(Tab:"Beta",Section:"Beta")
        SetCheckBox.run(ID:"//*[@id='CB_HISTORY_TAB']",Check:params."History Tab on View Submission")
        SetCheckBox.run(ID:"//*[@id='CB_EXTENDED_DATA_FOR_HISTORY_TAB']",Check:params."Extended Data for History Tab")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_GLOBAL_NAV_COMPONENT']",Check:params."Upgrade Global Navigation")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_COMMENTING_COMPONENT']", Check:params."Unified Commenting Experience")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_MERGE_IDEAS']", Check:params."Parent-child Merge Ideas")
        SetCheckBox.run(ID:"//*[@id='CB_RULES_ENGINE_IMPROVEMENTS']", Check:params."Rules Engine Updated UI")
        SetCheckBox.run(ID:"//*[@id='CB_STAGE_GATE_ACTION_ITEM']", Check:params."Stage Gate Action Item")
        SetCheckBox.run(ID:"//*[@id='CB_WS_ENABLE_EVAL_REORDERING_AND_COMMUNICATIONS']", Check:params."Evaluation reordering and communications")
        //Unregistered Users Submit Via Email
        SetCheckBox.run(ID:"//*[@id='CB_ALLOW_UNREGISTERED_USERS_SUBMIT_VIA_EMAIL']", Check:params."Allow Unregistered Users Submit Via Email")
        SetCheckBox.run(ID:"//*[@id='CB_VIEW_IDEA_3_NGA']", Check:params."View Idea 3 in Action Items and Manage Pages")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_RESEND_ACTION_ITEMS']", Check:params."Resend Action Items - Single Scale, Scorecard, and Development Steps")
        SetCheckBox.run(ID:"//*[@id='CB_GROUP_ASSIGNMENT_FOR_STEP_CONFIGURATION']", Check:params."Group Assignment for Step Configuration")
        SetCheckBox.run(ID:"//*[@id='CB_TEAM_NAME_CAPABILITIES']", Check:params."Team Name Capabilities")
        if(params."Allow Unregistered Users Submit Via Email"){
            if(params."Hold Submission Until Users Register or Post Submissions Immediately"=='Hold Submission Until Users Register'){
                Click.run(ID:"//*[@id='CB_QUARANTINE_SUBMISSION_UNTIL_REGISTERED']")
                SetCheckBox.run(ID:"//*[@id='CB_AUTO_REGISTRATION_INVITE_UNREGISTERED_EMAILS']",Check:params."Send Registration Email Following Submission")
            }else if(params."Hold Submission Until Users Register or Post Submissions Immediately"=='Post Submissions Immediately'){
                Click.run(ID:"//*[@id='CB_PASSTHROUGH_UNREGISTERED_EMAIL']")
                SetCheckBox.run(ID:"//*[@id='CB_PASSTHROUGH_INVITE_UNREGISTERED_EMAILS']",Check:params."Send Registration Email Following Submission")
            }
        }
        SetCheckBox.run(ID:"//*[@id='CB_IDEABOX_TEAM_SITE']", Check:params."Idea Box Team Site")
        Click.run(ID:"//*[@id='beta_beta_save_button']")
        sleep(2000)
        Click.run(ID:"//*[@data-test='modal-footer-submit']")
    }
}