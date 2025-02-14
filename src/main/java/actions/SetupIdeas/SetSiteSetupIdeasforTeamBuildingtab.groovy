package actions.SetupIdeas;

import actions.common.SetupCommon
import actions.selenium.Click
import actions.selenium.SetCheckBox

class SetSiteSetupIdeasforTeamBuildingtab{
    public void run(def params){

        SetupCommon.NavigateTab(Tab:"Ideas",Section:"Team Building")

        SetCheckBox.run(ID:"//*[@id='CB_WS_MULTI_SUBMITTERS']",Check:params."Multiple Submitters")
        SetCheckBox.run(ID:"//*[@id='CB_WS_MULTI_SUBMITTERS_POINTS']",Check:params."All submitters get points")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_FEATURE_FIND_TEAMMATES']",Check:params."Find Teammates")
        SetCheckBox.run(ID:"//*[@id='CB_WS_VOLUNTEER_AVAILABILITY']",Check:params."User Availability Flag")
        SetCheckBox.run(ID:"//*[@id='CB_USERS_APPLY_TO_JOIN_TEAMS']",Check:params."Users can apply to join teams")
        SetCheckBox.run(ID:"//*[@id='CB_ADD_ACCEPTED_USERS_TO_WORKSPACE_TEAM']",Check:params."Add Accepted Users to Workspace Team")
        SetCheckBox.run(ID:"//*[@id='CB_ADD_ACCEPTED_USERS_TO_SUBMISSION_TEAM']",Check:params."Add Accepted Users to Submission Team")

        Click.run(ID:"//*[@id='team_building_save_button']")

    }
}