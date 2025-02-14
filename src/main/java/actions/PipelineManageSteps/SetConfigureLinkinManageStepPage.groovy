package actions.PipelineManageSteps;

import actions.selenium.*

class SetConfigureLinkinManageStepPage{
    public void run(def params){
        
        Click.run(ID:"//*[contains(@data-test,'f-test-dropdown')]")
        if(params."Share Options"){
            Click.run(ID:"//*[contains(@class,'f-dropdown-options') and contains(@style,'display: block')]//*[contains(text(),'${params."Share Options"}')]")
        }
    }
}