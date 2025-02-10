package actions.PipelineSetup;

import actions.selenium.Click

class SetLeftSideTabInPipelineSetup{
    public static run(def params){
        
        Click.run(ID:"//*[@id='settings-left-tabs']//*[text()='${params."Tab"}']")
        
    }
}