package actions.SetupEnterpriseCommunities;

import actions.common.SetupCommon
import actions.selenium.*

class AddCommunity{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Initiatives",Section:"Communities")
        
        Click.run(ID:"//B[text()='Add Community' or text()='Create Community']")
        SetText.run(ID:"//INPUT[@id='level_title']",Text:params."Community Name")
        if(params.Action=="Create"){Click.run(ID:"//*[@id='add_level_message']//INPUT[@value='Create']")}
        else{Click.run(ID:"//*[@id='add_level_message']//INPUT[@value='Cancel']")}
        sleep(2000)
    }
}