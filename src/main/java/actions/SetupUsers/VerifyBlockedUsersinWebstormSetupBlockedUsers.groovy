package actions.SetupUsers;

import actions.common.SetupCommon
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyBlockedUsersinWebstormSetupBlockedUsers{
    public void run(def params){

        SetupCommon.NavigateTab(Tab:"Users",Section:"Deactivated Users")
        def verify = [:]
        verify.ID = "//*[@id='admin_blocked_user_list']//TD[contains(text(),'${params."User Name"}')]"
        verify.IDChildren = []
        if(params."User Email"){verify.IDChildren << "./..//*[contains(.,'${params."User Email"}')]"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}

        VerifyNumberOfMatches.run(verify) 
    }
}