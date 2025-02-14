package actions.SetupEnterpriseCommunities;

import actions.common.SetupCommon
import actions.selenium.*

class GotoCommunity{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Initiatives",Section:"Communities")
        
        //Click.run(ID:"//*[contains(@id,'_text') and contains(text(),'${params."Community Name to go to"}')]/..//IMG[contains(@src,'icon_move.gif')]")
        Click.run(ID:"//*[contains(@id,'_text') and contains(text(),'${params."Community Name to go to"}')]/..//A/I[contains(@class,'fa-level-down-alt')]")
        
        sleep(2000)
    }
}