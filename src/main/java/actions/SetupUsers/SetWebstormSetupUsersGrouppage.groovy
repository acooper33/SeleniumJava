package actions.SetupUsers;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click

class SetWebstormSetupUsersGrouppage{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Users",Section:"Groups")

        if(params."Create Team or Existing Team Name"=="Create Team") {
            SetText.run(ID:"//*[@id='new_group']",Text:params."Team Name Field")
            Click.run(ID:"//*[@id='groups_old_content']//*[text()='Create Team']")
            Click.run(ID:"//*[@id='eval_team_list']//TD[contains(text(),'${params."Team Name Field"}')]/..//IMG[contains(@title, 'Edit Team')]")

        }
        else {
            Click.run(ID:"//*[@id='eval_team_list']//TD[contains(text(),'${params."Create Team or Existing Team Name"}')]/..//IMG[contains(@title, 'Edit Team')]")

            if(params."Create Team or Existing Team Name"!=params."Team Name Field") {
                Click.run(ID:"//*[@id='team_group_edit']/IMG")
                SetText.run(ID:"//*[@id='new_team_name']",Text:params."Team Name Field")
                Click.run(ID:"//*[@id='team_group_edit']/INPUT[@value='Save']")
            }
        }

        if(params."Team Member Field") {
            params."Team Member Field".split(",").eachWithIndex{ name, x ->
                if(params."Add Member or Remove".split(",")[x]=="Add Member"){
                    SetText.run(ID:"//*[@id='g_m_input_xml']",Text:name)
                    sleep(2000)
                    Click.run(ID:"//*[@id='as_ul']//*[text()='${name}']/SMALL")
                    Click.run(ID:"//*[@id='eval_member_list_container']//*[text()='Add Member']")
                    sleep(2000)
                }
                else {Click.run(ID:"//*[@id='eval_member_list_container']/..//TD[contains(text(),'${name}')]/..//IMG[contains(@title,'Remove Team Member')]")
                     sleep(2000)} 
            }

        }
    }
}