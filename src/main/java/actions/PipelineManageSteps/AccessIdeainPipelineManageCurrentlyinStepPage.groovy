package actions.PipelineManageSteps;

import actions.selenium.*


class AccessIdeainPipelineManageCurrentlyinStepPage{
    public void run(def params){
         if(Exists.run(ID:"//*[@id='scores-tab' and contains(@class,'unselected')]")==1){
            Click.run(ID:"//*[@id='scores-tab']")
        }  
        ExplicitWait.run(ID:"//*[@id='scores_grid']")
        //sleep(2000)
        Click.run(ID:"//*[@id='overview_grid_holder']//TD[text()='${params."Idea name"}']")
        
        if(params."Click on Checkbox"){
            SetCheckBox.run(ID:"//*[@id='overview_grid_holder']//TD[text()='${params."Idea name"}']/..//INPUT",Check:params."Show Phases")
        }
        sleep(2000)
    }
}