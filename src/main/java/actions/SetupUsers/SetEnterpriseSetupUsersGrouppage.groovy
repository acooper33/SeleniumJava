package actions.SetupUsers;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click

class SetEnterpriseSetupUsersGrouppage{
    public void run(def params){

        SetupCommon.NavigateTab(Tab:"Users",Section:"EnterpriseSetupGroups")

        //Create/Search a Group
        if(params."Create Group or Search Group" == "Create Group") { 
            SetText.run(ID:"//*[@id='new_group']",Text:params."Group Name")
            Click.run(ID:"//*[@id='btnCreateGroup']")
        } else { if(params."Search Action" == "Search") {SetText.run(ID:"//*[@id='ent_member_group_search']",Text:params."Group Name")
                                                         Click.run(ID:"//*[@id='search_group']//*[text()='Search']")}
                else {Click.run(ID:"//*[@id='search_group']//*[text()='Show All Groups']")}
               }

        //Delete or Edit a Group
        if (params."Delete or Edit Group" == "Edit") { Click.run(ID:"//*[@id='group_list']//TD[contains(text(),'${params."Group Name"}')]/..//IMG[contains(@title, 'Edit Group')]")}
        else {Click.run(ID:"//*[@id='group_list']//TD[contains(text(),'${params."Group Name"}')]/..//IMG[contains(@title, 'Delete Group')]")}

        //Add or Remove Group member
        if(params."Group Member") {
            params."Group Member".split(",").eachWithIndex{ name, x ->
                if(params."Add Member or Remove".split(",")[x]=="Add Member"){
                    SetText.run(ID:"//*[@id='g_m_input_xml']",Text:name)
                    sleep(2000)
                    Click.run(ID:"//*[@id='as_ul']//*[text()='${name}']/SMALL")
                    Click.run(ID:"//*[@id='user_action']//*[@value ='Add Member']")
                	sleep(2000)}
                else {Click.run(ID:"//*[@id='group_member_list']/..//TD[contains(text(),'${name}')]/..//IMG[contains(@title,'Remove Group Member')]")
                      sleep(2000)} 
            }
        }

        //Edit the group name
        if(params."Edited Group Name") {
            Click.run(ID:"//*[@id='current_group_edit']/IMG")
            SetText.run(ID:"//*[@id='group_name_edit']",Text:params."Edited Group Name")
            if(params."Save or Cancel Edited Group Name") {Click.run(ID:"//*[@id='current_group_edit']/INPUT[@value='${params."Save or Cancel Edited Group Name"}']")}                                               
        }                               
    }
}
