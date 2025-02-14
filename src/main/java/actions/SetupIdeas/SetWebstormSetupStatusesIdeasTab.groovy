package actions.SetupIdeas;

import actions.selenium.SetText
import actions.selenium.Click
import actions.common.SetupCommon
import actions.selenium.SelectItem

class SetWebstormSetupStatusesIdeasTab{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Ideas",Section:"Statuses")
        
        if (params."Status Name to Modify or Add"=="Add"){
            Click.run(ID:"//*[@id='add_status_button']")
            if(params."Status Name"){
                SetText.run(ID:"//input[@value='Enter Custom Status Name']", Text:"${params."Status Name"}")
            }
            if(params."System Status"){
             	SelectItem.run(ID:"//input[@value='Enter Custom Status Name']/../../..//select[@id='system_status']", "Visible Text":params."System Status") 
            }
            if(params."Description"){
                SetText.run(ID:"//input[@value='Enter Status Description']", Text:"${params."Description"}")
            }
            Click.run(ID:"//*[@id='save_status_button']")
        }
        else{
            if(params."Description"){
                SetText.run(ID:"//input[starts-with(@id,'custom-status-description') and @value='${params."Status Name to Modify or Add"}']/../../..//input[starts-with(@id,'custom-status-name')]", Text:params."Description")
            }
            if(params."System Status"){
                SelectItem.run(ID:"//input[starts-with(@id,'custom-status-description') and @value='${params."Status Name to Modify or Add"}']/../../..//select[@id='system_status']", "Visible Text":params."System Status")
            }
            if(params."Status Name"){
                SetText.run(ID:"//input[starts-with(@id,'custom-status-description') and @value='${params."Status Name to Modify or Add"}']", Text:params."Status Name")
            }
            Click.run(ID:"//*[@id='save_status_button']")
       }
        
    }
}