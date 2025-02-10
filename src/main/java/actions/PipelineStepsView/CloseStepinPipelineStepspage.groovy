package actions.PipelineStepsView;

import actions.selenium.Click
import actions.selenium.SetCheckBox

class CloseStepinPipelineStepspage{
    public void run(def params){
        //SPAN[@class='step_header_name' and text()='Single Scale']/../DIV[contains(@class,'img-dropdown')]
        
        Click.run(ID:"//SPAN[@class='step_header_name' and text()='${params."Step to Close"}']/../DIV[contains(@class,'img-dropdown')]")
        Click.run(ID:"//SPAN[@class='step_header_name' and text()='${params."Step to Close"}']/../..//*[text()='Close Step']")
        SetCheckBox.run(ID:"//*[@id='checkbox']",Check:params."I Understand")
        if(params."Action"=="Cancel"){Click.run(ID:"//A[text()='Cancel']")}
        else{Click.run(ID:"//*[@id='bi-modal-button']//*[text()='Close Step']")}
    }
}