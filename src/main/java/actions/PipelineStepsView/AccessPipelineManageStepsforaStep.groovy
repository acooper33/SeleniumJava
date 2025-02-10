package actions.PipelineStepsView;

import actions.selenium.*

class AccessPipelineManageStepsforaStep{
    public void run(def params){
        Click.run(ID:"//SPAN[@class='step_header_name' and text()='${params."Step Name"}']/../DIV[contains(@class,'img-dropdown')]")
        Click.run(ID:"(//SPAN[@class='step_header_name' and text()='${params."Step Name"}']/../..//*[contains(text(),'Manage ')])[1]")
        sleep(2000)
    }
}