package actions.PipelineManageSteps;

import actions.selenium.Click

class SetActionItemsProgressExport{
    public void run(def params){
        
        Click.run(ID:"//*[@id='export-grid']")
    }
}