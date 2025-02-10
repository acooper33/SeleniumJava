package actions.PipelineSetup;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.MouseOver

class EditScorecardTemplateName{
    public void run(def params){
        if(params."New Name"){
            MouseOver.run(ID:"//*[@id='scorecard-name-edit']")
            sleep(1000)
            Click.run(ID:"//*[@id='scorecard-name-edit']")
            sleep(1000)
            SetText.run(ID:"//*[@id='template-name-input']", Text:params."New Name")
            if(params.Action=='Save'){Click.run(ID:"//*[@id='confirm-change-name']")}
            else if(params.Action=='Cancel'){Click.run(ID:"//*[@id='cancel-change-name']")}
        }  
    }
}