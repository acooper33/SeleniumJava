package actions.SetupIdeas;

import actions.common.SetupCommon
import actions.selenium.Click
import actions.selenium.SetCheckBox

class SetWebstormSetupIdeasforHistoryTab{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Ideas",Section:"History")
        
        if (params."Roles"=="None"){Click.run(ID:"//*[@id='role-none']")}
        else if(params."Roles"=="All Users"){Click.run(ID:"//*[@id='role-all-users']")}
        else if(params."Rolse"=="Selected Users"){Click.run(ID:"//*[@id='role-selected-users']")}
        SetCheckBox.run(ID:"//*[@id='CB_USER_TYPE_EVALUATOR']", Check:params."Evaluators")
        SetCheckBox.run(ID:"//*[@id='CB_USER_TYPE_SUBMITTER']", Check:params."Submitters")
        SetCheckBox.run(ID:"//*[@id='CB_HISTORY_TAB_EVENTS_ANONYMOUS']", Check:params."Make events anonymous")
        if(params."Action"=="Save"){Click.run(ID:"//*[@id='history_tab_save_button']")}
    }
}