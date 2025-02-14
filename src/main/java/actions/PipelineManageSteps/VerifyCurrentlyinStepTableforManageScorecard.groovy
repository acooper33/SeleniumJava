package actions.PipelineManageSteps;

import actions.selenium.Click
import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Exists

class VerifyCurrentlyinStepTableforManageScorecard{
    public void run(def params){

        if(params."Step Name to Manage (optional)"){
            Click.run(ID:"//SPAN[@class='step_header_name' and text()='${params."Step Name to Manage (optional)"}']/../DIV[contains(@class,'img-dropdown')]")
            Click.run(ID:"//SPAN[@class='step_header_name' and text()='${params."Step Name to Manage (optional)"}']/../..//*[text()='Manage Scorecard']")
        }
        if(Exists.run(ID:"//*[@id='scores-tab' and contains(@class,'unselected')]")==1){
            Click.run(ID:"//*[@id='scores-tab']")
        }        
        sleep(10000)

        def verify = [:]
        verify.IDChildren = []
        verify.ID = "//*[@class='idea_list larger-order']//TD[.='${params."Idea Name"}']"
        if(params."Code"){verify.IDChildren << "./../TD[@class='idea-code-cell sortable renderable' and text()='${params."Code"}']"}
        if(params."Overall Score"){verify.IDChildren << "./../TD[@class='string-cell score-cell sortable renderable' and text()='${params."Overall Score"}']"}
        if(params."Percentile"){verify.IDChildren << "./../TD[@class='percentile-cell renderable' and text()='${params."Percentile"}']"}
        if(params."Variance"){verify.IDChildren << "./../TD[@class='variance-cell renderable' and text()='${params."Variance"}']"}
        if(params."Comment Count"){verify.IDChildren << "./../TD[@class='review-string-cell renderable' and text()='${params."Comment Count"}']"}
        if(params."Vote Score"){verify.IDChildren << "./../TD[@class='idea-vote-score renderable' and text()='${params."Vote Score"}']"}
        if(params."Views"){verify.IDChildren << "./../TD[@class='idea-view-count renderable' and text()='${params."Views"}']"}
        if(params."Evaluators"){
            params."Evaluators".split(",").eachWithIndex{ name, x ->
                def score = params."Individual Evaluator Score".split(",")
                verify.IDChildren << "./../TD[contains(@class,'individual-score-cell')][${x+1}][text()='${score[x]}']"
                verify.IDChildren << "./../../../../..//TH[contains(@class,'screener-header-cell')][${x+1}]//*[@tooltip-text='${name}']"
            }
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)
    }
}
