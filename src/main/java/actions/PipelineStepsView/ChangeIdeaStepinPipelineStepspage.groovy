package actions.PipelineStepsView;

import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem

class ChangeIdeaStepinPipelineStepspage{
    public void run(def params){
        Click.run(ID:"//*[@id='actions_dropdown']")
        Click.run(ID:"//*[@id='action-step']")
        SelectItem.run(ID:"//*[@id='update_idea_select']","Visible Text":params."Step")
        
        SetCheckBox.run(ID:"//*[@id='do-not-show-alert']",Check:params."Don't show me this warning again")
        sleep(5000)
        if(params.Action){
            if(params.Action=="Change Step"){
                println("Clicking the green button")
                Click.run(ID:"//*[@class='green_btn_container']/*[text()='Change Step']")}
            else{Click.run(ID:"//*[@id='change_status_popup']//*[text()='Cancel']")}
        }
        sleep(5000)
    }
}