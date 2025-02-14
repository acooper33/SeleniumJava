package actions.PipelineManageSteps;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Click

class VerifytheEvaluatorsthatCompletedtheScorecard{
    public void run(def params){

        if(params."Idea (optional)"){
            Click.run(ID:"//*[@class='idea_list larger-order']//*[contains(@class,'title') and text()='${params."Idea (optional)"}']")
        }
        def verify = [:]
        verify.ID = "//*[@id='scorecard-scores']//*[contains(@class,'scorecard-question-title') and contains(text(),'${params."Question"}')]/following-sibling::DIV[2]//*[@class='answer-title' and text()='${params."Answer"}']/../*[@class='stats-num-answered' and contains(@tooltip-text,'${params."Evaluator"}')]"
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify) 
    }
}