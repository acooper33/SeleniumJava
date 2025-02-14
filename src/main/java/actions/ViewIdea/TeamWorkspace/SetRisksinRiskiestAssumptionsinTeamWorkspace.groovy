package actions.ViewIdea.TeamWorkspace;

import actions.selenium.*
import actions.common.TeamWorkspaceCommon

class SetRisksinRiskiestAssumptionsinTeamWorkspace{
    public void run(def params){

        if(params."Set Tab (optional)"){TeamWorkspaceCommon.NavigateTab(Tab:params."Set Tab (optional)")}
        sleep(2000)
        if(params."Add or Edit"=="Add"){
            if(params."Row Number"=="1"){
                Click.run(ID:"//*[@id='add-entry']")
            }
            SetText.run(Text:params."Risk",ID:"//*[@id='new-record-input']","Type of Clear":"Cut")
            //SendKeys.run(ID:"//*[@id='new-record-input']",Key:"ENTER")
            SendKeyboardAction.run(Button:"ENTER")
            sleep(2000)
        } else { 
            if(params."Risk"){
                SetText.run(Text:params."Risk",ID:"//*[@id='table-body-row-${params."Row Number".toInteger()-1}-cell-0-input']","Type of Clear":"Cut")
                Click.run(ID:"//*[@id='add-entry']") }
                //SendKeys.run(ID:"//*[@id='table-body-row-${params."Row Number".toInteger()-1}-cell-0-input']",Key:"ENTER")}
        }
        sleep(2000)
        if(params."Status"){
            SetFocus.run(ID:"//*[@id='table-body-row-${params."Row Number".toInteger()-1}-cell-0']")
            SelectItem.run(ID:"//*[@id='table-body-row-${params."Row Number".toInteger()-1}-cell-1']//*[@id='grid-select-status']","Visible Text":params."Status")}     
        if(params."Related Area"){
            SetFocus.run(ID:"//*[@id='table-body-row-${params."Row Number".toInteger()-1}-cell-0']")
            SelectItem.run(ID:"//*[@id='table-body-row-${params."Row Number".toInteger()-1}-cell-2']//*[@id='grid-select-related-area']","Visible Text":params."Related Area")}     
    }
}