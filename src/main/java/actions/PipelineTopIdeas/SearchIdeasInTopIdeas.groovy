package actions.PipelineTopIdeas;

import actions.selenium.Click
import actions.selenium.SendKeys

class SearchIdeaInTopIdeas{
    public void run(def params){
        if(params."Search Value"){
            SendKeys.run(ID:"//input[contains(@id,'filter-search')]", Text:params."Search Value")
            //sleep(2000)
        }
        if(params."Search with 'Enter'?" == true){
            SendKeys.run(ID:"//input[contains(@id,'filter-search')]", Key:"ENTER")
            sleep(2000)
        }
        if(params."Clear Search"==true){
            Click.run(ID:"//*[@data-tooltip-id='fractal-input-clear']/I")
            sleep(3000)
        }
    }
}