package actions.PipelineStepsView;

import actions.selenium.Click

class DeleteIdeasinPipelineStepsViewpage{
    public void run(def params){
        Click.run(ID:"//*[@id='actions_dropdown']")
        Click.run(ID:"//*[@id='action-delete']")
        sleep(2000)
    }
}