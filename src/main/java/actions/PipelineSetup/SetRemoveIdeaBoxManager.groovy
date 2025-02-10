package actions.PipelineSetup;

import actions.selenium.Click
import actions.selenium.SetCheckBox

class SetRemoveIdeaBoxManager{
    public void run(def params){
        
        sleep(2000)
        if(params."Remove Idea Box Managers as Pipeline Managers from all pipelines"== true){Click.run(ID:"//*[@class='f-delete-pipeline-admins-checkbox']//*[not(contains(@class,'f-checkbox-checked'))]//INPUT/..")}
        if(params."Remove Idea Box Managers as Pipeline Managers from all pipelines"== false){Click.run(ID:"//*[@class='f-delete-pipeline-admins-checkbox']//*[contains(@class,'f-checkbox-checked')]//INPUT/..")}
        
        if(params."Action"){
            if(params."Action" == "Continue"){
                Click.run(ID:"//*[@data-test ='modal-footer-submit']")
            } else {
                Click.run(id:"//*[@data-test ='modal-footer-cancel']")
            }
        }
    }
}