package actions.SetupEnterpriseCommunities;

import actions.common.SetupCommon
import actions.selenium.*

class DeleteCommunity{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Initiatives",Section:"Communities")
        Click.run(ID:"//B[text()='Delete Community']")
        
        if(params.Action=="Delete"){Click.run(ID:"//*[@id='delete_level_message']//INPUT[@value='Delete']")}
        else{Click.run(ID:"//*[@id='delete_level_message']//INPUT[@value='Cancel']")}
        sleep(2000)
    }
}