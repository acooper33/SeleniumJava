package actions.PipelineManageSteps;

import actions.selenium.Click

class SetActionsMenuinManageStepsPages{
    public void run(def params){
        
        Click.run(ID:"//*[@id='scores_actions_btn']")
        Click.run(ID:"//*[@id='scores_actions_menu']//LI[contains(.,'${params."Actions Menu Option"}')]")
        
    }
}