package actions.SetupIdeas;

import actions.common.SetupCommon
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SetText
import actions.selenium.SetFocus

class SetSiteSetupIdeasTeamConfiguration{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Ideas",Section:params."Section")
        if(params."Multiple Submitters"){SetCheckBox.run(ID:"//*[@id='CB_WS_MULTI_SUBMITTERS']",Check:params."Multiple Submitters")}
      	if(params."Limit team size to"){
            Click.run(ID:"//*[@id='CB_ENABLE_TEAM_SIZE_LIMIT']")
            sleep(1000)
            SetText.run(ID:"//INPUT[@id='team_size_limit']", Text:params."Limit team size to", "Type of Clear":"Cut")
        }
       	SetCheckBox.run(ID:"//*[@id='CB_SITE_LEVEL_TEAM_NAME_CAPABILITIES']",Check:params."Team name capabilities")
        SetCheckBox.run(ID:"//*[@id='CB_ADD_ACCEPTED_USERS_TO_WORKSPACE_TEAM']",Check:params."Add Accepted Users to Workspace Team")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_USER_REG_TEAM_SUBMISSION']",Check:params."Allow user registration on team submissions")
        SetCheckBox.run(ID:"//*[@id='CB_WS_VOLUNTEER_AVAILABILITY']",Check:params."User Availability Flag")
        SetCheckBox.run(ID:"//*[@id='CB_USERS_APPLY_TO_JOIN_TEAMS']",Check:params."Users can apply to join teams")
        Click.run(ID:"//*[@id='team_building_save_button']")
    }
}