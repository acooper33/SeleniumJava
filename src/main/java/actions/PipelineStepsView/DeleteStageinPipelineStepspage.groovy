package actions.PipelineStepsView;

import actions.selenium.Click

class DeleteStageinPipelineStepspage{
    public void run(def params){
     	Click.run(ID:"//*[@class='stage_name step_view_nga_header']/*[text()='${params."Stage to Delete"}']/../..//A[@CLASS='blank_delete_stage btn-danger']")
        sleep(3000)
    }
}