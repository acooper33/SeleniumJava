package actions.ViewIdea.TeamWorkspace;

import actions.selenium.Click
import actions.selenium.SetText
import actions.common.TeamWorkspaceCommon

class SetSettingsinTeamWorkspace{
    public void run(def params){
        if(params."Verify in Which Tab (optional)"){TeamWorkspaceCommon.NavigateTab(Tab:params."Verify in Which Tab (optional)")}
        if(params."Option"=="Integrate with Box"){
            Click.run(ID:"//label[text()='Integrate with Box']")
            Click.run(ID:"//label[text()='Integrate with Box']")
            Click.run(ID:"//*[contains(@id,'file-option-2')]")
            sleep(1000)
            SetText.run(ID:"//input[@id='box-link-url']", Text:params."Shared Link", "Type of Clear":"Cut")
        }
        else if(params."Option"=="Upload Files to Project"){
            Click.run(ID:"//*[contains(@id,'file-option-1') and @type='radio']", "Type of Click":"Javascript")
        }
        sleep(1000)
        if(params."Action"=="Save"){Click.run(ID:"//*[@id='settings-save']")}
    }
}