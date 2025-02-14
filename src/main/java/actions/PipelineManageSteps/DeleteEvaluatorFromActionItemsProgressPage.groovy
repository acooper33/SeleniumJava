package actions.PipelineManageSteps;

import actions.selenium.*

class DeleteEvaluatorFromActionItemsProgressPage{
    public void run(def params){
        
        Click.run(ID:"//*[text()='${params."Evaluator To Be Deleted"}']/../..//*[@class='remind-cell sortable renderable']")
        Click.run(ID:"//*[text()='${params."Evaluator To Be Deleted"}']/../..//*[@id='overview-grid-remove']")
        if(params."Action"){
            Click.run(ID:"//*[@class='bimodal-footer']//*[text()='${params."Action"}']")  
        }        
    }
}