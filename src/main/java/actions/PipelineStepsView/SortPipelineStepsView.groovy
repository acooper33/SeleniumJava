package actions.PipelineStepsView;

import actions.selenium.Click


class SortPipelineStepsView{
    public void run(def params){
        
        Click.run(ID:"//*[@id='steps-view-sorting-button']")
        if(params."Sort Options"){
            params."Sort Options".split(",").each{option -> 
                Click.run(ID:"//*[@id='sorting-popup']//div[text()='${option}']")}
        	}
        sleep(3000)
        if(params."Close Sort Options"==true){Click.run(ID:"//*[@id='steps-view-sorting-button']")}
    }
}