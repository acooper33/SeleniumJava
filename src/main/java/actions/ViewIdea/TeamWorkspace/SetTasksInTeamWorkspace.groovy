package actions.ViewIdea.TeamWorkspace;

import actions.selenium.*
import actions.common.TeamWorkspaceCommon
import actions.selenium.SendKeys
import actions.selenium.utils.Elements
import org.openqa.selenium.JavascriptExecutor
import actions.selenium.Browser

class SetTasksInTeamWorkspace{
    public void run(def params){
   
        if(params."Tab (optional)"){TeamWorkspaceCommon.NavigateTab(Tab:params."Tab (optional)")}
        sleep(2000)
        if(params."Add or Edit"=="Add"){
            if(params."Row Number"=="1"){
                Click.run(ID:"//*[@id='add-entry']")
            }
            SetText.run(Text:params."Todo",ID:"//*[@id='new-record-input']","Type of Clear":"Cut")
            //SendKeys.run(ID:"//*[@id='new-record-input']",Key:"ENTER")
            SendKeyboardAction.run(Button:"ENTER")
        } else { 
            if(params."Todo"){
                SetText.run(Text:params."Todo",ID:"//*[@id='table-body-row-${params."Row Number".toInteger()-1}-cell-0-input']","Type of Clear":"Cut")
                SendKeys.run(ID:"//*[@id='table-body-row-${params."Row Number".toInteger()-1}-cell-0-input']",Key:"ENTER")}
        }
        sleep(2000)
        if(params."Mark Complete or Mark Incomplete"){
            Click.run(ID:"//*[@id='table-body-row-${params."Row Number".toInteger()-1}-cell-1-input']/../../..//*[@data-tooltip-content='${params."Mark Complete or Mark Incomplete"}']","Type of Click":"Javascript")
        }
        if(params."Assignee"){
            sleep(2000)
            SetFocus.run(ID:"//*[@id='table-body-row-${params."Row Number".toInteger()-1}-cell-0']")
        	SelectItem.run(ID:"//*[@id='table-body-row-${params."Row Number".toInteger()-1}-cell-2']//*[@id='grid-select-related-area']","Visible Text":params."Assignee")
        }
        sleep(3000)
    }
}