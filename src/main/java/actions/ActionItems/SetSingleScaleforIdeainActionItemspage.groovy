package actions.ActionItems;

import actions.selenium.Click
import actions.selenium.Exists
import actions.ActionItems.SetGeneralEvaluationScorecardforIdeainActionItemspage

class SetSingleScaleforIdeainActionItemspage{
    public void run(def params){
        SetGeneralEvaluationScorecardforIdeainActionItemspage.skipTourScorecard()
        sleep(2000)
        if(params."What is your initial impression of this idea"){
            Click.run(ID:"//*[@id='idea_rate_list']/LI[text()='${params."What is your initial impression of this idea"}']")
        	sleep(2000)
        }
        
    }
}