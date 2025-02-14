package actions.SetupEnterpriseCommunities;

import actions.common.SetupCommon
import actions.selenium.*

class SelectCommunity{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Initiatives",Section:"Communities")
        
        sleep(2000)
        Click.run(ID:"//*[contains(@id,'_text') and contains(text(),'${params."Community Name"}')]")
        if(Exists.run(ID:"//*[contains(@id,'_text') and contains(text(),'${params."Community Name"}')]..//IMG[contains(@src,'maximize')]")>0){
            Click.run(ID:"//*[contains(@id,'_text') and contains(text(),'${params."Community Name"}')]..//IMG[contains(@src,'maximize')]")
        }
    }
}