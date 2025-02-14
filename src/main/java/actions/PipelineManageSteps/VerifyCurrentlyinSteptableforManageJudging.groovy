package actions.PipelineManageSteps;
import actions.selenium.Click
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyCurrentlyinSteptableforManageJudging{
    public void run(def params){

        if(params."Step Name to Manage (optional)"){
            Click.run(ID:"//SPAN[@class='step_header_name' and text()='${params."Step Name to Manage (optional)"}']/../DIV[contains(@class,'img-dropdown')]")
            Click.run(ID:"//SPAN[@class='step_header_name' and text()='${params."Step Name to Manage (optional)"}']/../..//*[text()='Manage ${params."Step Name to Manage (optional)"}']")
        }
           //sleep(5000)
		   Click.run(ID:"//*[@id='scores-tab']")
           sleep(2000)

            def verify = [:]
            verify.IDChildren = []
            verify.ID = "(//TABLE)//TD[.='${params."Idea Name"}']"
            if(params."Overall Score"){verify.IDChildren << "./../TD[@class='string-cell score-cell sortable renderable' and text()='${params."Overall Score"}']"}
            if(params."Individual Evaluator Rating"){verify.IDChildren << "./../TD[@class='individual-score-cell renderable' and text()='${params."Individual Evaluator Rating"}']"}
        	if(params."Order"){verify.IDChildren << "./../TD[@class='review-string-cell renderable' and text()='${params."Order"}']"}

            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)
        
    }
}
