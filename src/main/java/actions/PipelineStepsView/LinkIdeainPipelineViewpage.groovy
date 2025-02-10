package actions.PipelineStepsView;

import actions.selenium.Click

class LinkIdeainPipelineViewpage{
    public void run(def params){
    	Click.run(ID:"//*[@id='actions_dropdown']")  
        Click.run(ID:"//A[@id='action-link']")
        if(params.Action == "Link Ideas"){
            println("we're in Link Ideas")
            Click.run(ID:"//*[@class='green_btn_center' and text()='Link Ideas']")
        }else{
            Click.run(ID:"//A[@class='bimodal-secondary' and text()='Cancel']")
            println("we're in Link Ideas")
        }
    }
}