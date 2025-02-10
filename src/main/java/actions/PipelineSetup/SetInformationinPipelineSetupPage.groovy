package actions.PipelineSetup;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SetCheckBox

class SetInformationinPipelineSetupPage{
    public void run(def params){

        if(params."Name"){
            SetText.run(ID:"//*[@id='pipeline-name']",Text:params."Name")
        }
        if(params."Description"){
            SetText.run(ID:"//*[@id='pipeline-desc']",Text:params."Description")
        }
        SetCheckBox.run(ID:"//*[@id='research-pipeline-flag']",Check:params."This is a Research Pipeline")
        Click.run(ID:"//*[@id='save-information-btn']")
    }
}