package actions.PipelineStepsView;

import actions.selenium.Click

class DeleteStepinPipelineStepspage{
    public void run(def params){
        Click.run(ID:"//SPAN[@class='step_header_name' and text()='${params."Step to Delete"}']/../DIV[contains(@class,'img-dropdown')]")
        Click.run(ID:"//SPAN[@class='step_header_name' and text()='${params."Step to Delete"}']/../..//*[text()='Delete Step']")
        sleep(3000)
    }
}