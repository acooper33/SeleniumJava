package actions.SetupIdeas;

import actions.common.SetupCommon
import actions.selenium.SetCheckBox
import actions.selenium.Click
import actions.selenium.ExecuteJavascript

class SetWebstormSetupIdeasforTeamWorkspaceTab{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Ideas",Section:"Team Workspace")

        SetCheckBox.run(ID:"//*[@id='CB_BUSINESS_MODEL']",Check:params."Team Workspace")
        SetCheckBox.run(ID:"//*[@id='CB_PROJECT_MILESTONES_TAB']",Check:params."Milestones Tab")
        SetCheckBox.run(ID:"//*[@id='CB_PROJECT_TASKS_TAB']",Check:params."Tasks Tab")
        SetCheckBox.run(ID:"//*[@id='CB_PROJECT_BUSINESS_MODEL_TAB']",Check:params."Business Model Tab")
        if(params."Type of Model"){
            if(params."Type of Model"=="Business Model Canvas"){
                Click.run(ID:"//*[@value='BUSINESS_MODEL_CANVAS']")
            } else {Click.run(ID:"//*[@value='SIMPLE_BUSINESS_MODEL']")}
        }
        SetCheckBox.run(ID:"//*[@id='CB_PROJECT_RISKS_TAB']",Check:params."Risks Tab")
        SetCheckBox.run(ID:"//*[@id='CB_BUSINESS_IMPACT_TAB']",Check:params."Business Impact Tab")
        SetCheckBox.run(ID:"//*[@id='CB_PROJECT_FILES_TAB']",Check:params."Files Tab")
        SetCheckBox.run(ID:"//*[@id='CB_DISPLAY_WORKSPACE_TEAM_ON_VIEW_IDEA']",Check:params."Display Workspace Team on View Idea")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_TEAM_WORKSPACE_MEMBERS_EDIT_BUSINESS_IMPACT']",Check:params."Allow Team Workspace Members to Edit Business Impact")
        SetCheckBox.run(ID:"//*[@id='CB_WS_ENABLE_TWS_EMAIL_NOTIFICATIONS']", Check:params."Team Workspace Email Notifications")
        SetCheckBox.run(ID:"//*[@id='CB_WS_ENABLE_TWS_ADDED_TEAM_MEMBERS_EMAIL_NOTIFICATION']", Check:params."Added Team Members")
        SetCheckBox.run(ID:"//*[@id='CB_WS_ENABLE_TWS_MILESTONES_EMAIL_NOTIFICATION']", Check:params."Milestones")
        SetCheckBox.run(ID:"//*[@id='CB_WS_ENABLE_TWS_TODOS_EMAIL_NOTIFICATION']", Check:params."To-Dos")
        SetCheckBox.run(ID:"//*[@id='CB_WS_ENABLE_TWS_RISKIEST_ASSUMPTION_EMAIL_NOTIFICATION']", Check:params."Riskiest Assumption")
        SetCheckBox.run(ID:"//*[@id='CB_WS_ENABLE_TWS_FILES_EMAIL_NOTIFICATION']", Check:params."Files")
        Click.run(ID:"//*[@id='team_workspace_save_button']")
        
        if(params."Scroll To Top"==true){
             ExecuteJavascript.run(Code:"window.scrollTo(100, 0);")
        }
    }
}