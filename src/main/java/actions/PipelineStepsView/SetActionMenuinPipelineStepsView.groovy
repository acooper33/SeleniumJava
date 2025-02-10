package actions.PipelineStepsView;

import actions.selenium.Click

class SetActionMenuinPipelineStepsView{
    public static run(def params){
        
        if(params."Menu Option"){
            Click.run(ID:"//*[@id='actions_dropdown']")
            Click.run(ID:"//*[contains(@class,'dropdown-menu')]//*[text()='${params."Menu Option"}']/..")
        }       
    }
}