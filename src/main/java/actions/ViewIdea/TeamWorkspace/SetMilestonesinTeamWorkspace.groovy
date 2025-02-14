package actions.ViewIdea.TeamWorkspace;

import actions.selenium.*
import actions.common.TeamWorkspaceCommon

class SetMilestonesinTeamWorkspace{
    public void run(def params){
    if(params."Tab (optional)"){TeamWorkspaceCommon.NavigateTab(Tab:params."Tab (optional)")}
        sleep(2000)
        if(params."Add or Edit"=="Add"){
            if(params."Row Number"=="1"){
                Click.run(ID:"//*[@id='add-entry']")
            }
            SetText.run(Text:params."Milestone",ID:"//*[@id='new-record-input']","Type of Clear":"Cut")
            SendKeys.run(ID:"//*[@id='new-record-input']",Key:"ENTER")
            sleep(2000)
        } else { 
            if(params."Milestone"){
                SetText.run(Text:params."Milestone",ID:"//*[@id='table-body-row-${params."Row Number".toInteger()-1}-cell-0-input']","Type of Clear":"Cut")
                Click.run(ID:"//*[@id='add-entry']") }
                //SendKeys.run(ID:"//*[@id='table-body-row-${params."Row Number".toInteger()-1}-cell-0-input']",Key:"ENTER")}
        }
        if(params."Mark Complete or Mark Incomplete"){
            Click.run(ID:"//*[@id='table-body-row-${params."Row Number".toInteger()-1}-cell-1-input']/*[text()='${params."Mark Complete or Mark Incomplete"}']/..","Type of Click":"Javascript")
        }  
    }
}