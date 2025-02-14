package actions.SetupBeta;

import actions.common.SetupCommon
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.ExecuteJavascript

class SetWebstormSetupforBetaBetatab{
    public void run(def params){
        
   		SetupCommon.NavigateTab(Tab:"Beta",Section:"Beta")
        SetCheckBox.run(ID:"//*[@id='CB_WS_SHARE_DIALOG']", Check:params."Share Dialog")
        SetCheckBox.run(ID:"//*[@id='CB_WS_SHARE_DIALOG_FOR_END_USERS']", Check:params."Share Dialog For End Users")
        SetCheckBox.run(ID:"//*[@id='CB_FEATURE_NEW_NAV_AND_ADMIN_BAR']", Check:params."Enable Dynamic Navigation with Admin bar")
       	SetCheckBox.run(ID:"//*[@id='CB_HISTORY_TAB']", Check:params."Enable History Tab on View Submission")
  		SetCheckBox.run(ID:"//*[@id='CB_EXTENDED_DATA_FOR_HISTORY_TAB']", Check:params."Enable Extended Data for History Tab")
        SetCheckBox.run(ID:"//*[@id='CB_WS_UNIFIED_LOGIN']", Check:params."Unified Login Page")
        SetCheckBox.run(ID:"//*[@id='CB_WS_ENABLE_ADMIN_PERMISSION_IN_SUBMISSION_QUESTION']", Check:params."Enable Administrator Permission option in Submission Questions")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_SUBMIT_ON_BEHALF']", Check:params."Submit Ideas on Behalf of Other Users")
//        SetCheckBox.run(ID:"//*[@id='CB_VIEW_IDEA_3']",Check:params."View Idea 3.0")
//        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_BUSINESS_IMPACT_TAB']",Check:params."Business impact tab")
        if(params."Disable Step Evaluator Limit"){
            SetCheckBox.run(ID:"//*[@id='CB_DISABLE_STEP_EVALUATOR_LIMIT']",Check:params."Disable Step Evaluator Limit")
            SetupCommon.setWarningModal("Tick the Checkbox":true, "Action":"Update")
        }
        
         
        Click.run(ID:"//*[@id='beta_beta_save_button']")
        sleep(2000)
        Click.run(ID:"//*[@data-test='modal-footer-submit']")
        ExecuteJavascript.run(Code:"window.scrollTo(0, 0);")
    }
}