package actions.SetupEnterpriseCommunities;

import actions.common.SetupCommon
import actions.selenium.*
    
class UpdateCommunity{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Initiatives",Section:"Communities")
        
        sleep(2000)
        SetText.run(ID:"//*[@id='chosen_level_name']",Text:params."New Community Name")
        if(params."Apps"){
            params."Apps".split(",").eachWithIndex{ name, x ->
                SetCheckBox.run(ID:"//*[@id='children_right']/*[contains(.,'${name}')]/INPUT", Check:params."Checkbox Check".split(",")[x].toBoolean())
            }
        }
        Click.run(ID:"//*[@id='update_pool']")
        sleep(2000)
    }
}