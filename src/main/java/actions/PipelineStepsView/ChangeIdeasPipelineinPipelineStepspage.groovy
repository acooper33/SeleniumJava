package actions.PipelineStepsView;

import actions.selenium.Click
import actions.selenium.SelectItem

class ChangeIdeasPipelineinPipelineStepspage{
    public void run(def params){
        Click.run(ID:"//*[@id='actions_dropdown']")
        println("clicked on dropdown")
        Click.run(ID:"//*[@id='action-change_ws']")
        println("clicked on action change")
        println("Pipeline to select: ${params."Pipeline"}")
        SelectItem.run(ID:"//*[@id='change_ws_selections']", "Visible Text":params."Pipeline")
        sleep(1000)
        SelectItem.run(ID:"//*[@id='change_ws_category']", "Visible Text":params."Category")
        SelectItem.run(ID:"//*[@id='change_ws_status']", "Visible Text":params."Status")
        
        println("Action is ${params.Action}")
        if(params.Action=="Change Pipeline"){Click.run(ID:"//*[@id='change_webstorm_button']")}
        else{Click.run(ID:"//A[text()='Cancel']")}
        sleep(3000)
    }
}