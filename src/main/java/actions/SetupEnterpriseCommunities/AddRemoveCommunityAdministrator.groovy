package actions.SetupEnterpriseCommunities;

import actions.common.SetupCommon
import actions.selenium.*

class AddRemoveCommunityAdministrator{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Initiatives",Section:"Communities")
        
        if(params."Add or Remove"=="Add"){
            SetText.run(ID:"//*[@id='pool_admin_input_xml']",Text:params."User")
            Click.run(ID:"//*[@id='btn_add_admin_id']//INPUT[@value='Add Administrator']")
        }
        else{Click.run(ID:"//*[@id='admin_id']//*[contains(text(),'${params."User"}')]/..//IMG[@title='Remove Administrator']")}
        sleep(2000)
    }
}