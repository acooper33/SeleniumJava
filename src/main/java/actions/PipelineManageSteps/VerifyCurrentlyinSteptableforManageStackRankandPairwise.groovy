package actions.PipelineManageSteps;
import actions.selenium.Click
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyCurrentlyinSteptableforManageStackRankandPairwise{
   public void run(def params){
        
          if(params."Step Name to Manage (optional)"){
           	Click.run(ID:"//SPAN[@class='step_header_name' and text()='${params."Step Name to Manage (optional)"}']/../DIV[contains(@class,'img-dropdown')]")
        	Click.run(ID:"//SPAN[@class='step_header_name' and text()='${params."Step Name to Manage (optional)"}']/../..//*[text()='Manage ${params."Step Name to Manage (optional)"}']")   
        }
        
        Click.run(ID:"//*[@id='scores-tab']")
        sleep(2000)
        
        def verify = [:]
        verify.IDChildren = []
        verify.ID = "(//TABLE)//TD[.='${params."Title"}']"
        if(params."Overall Rank"){verify.IDChildren << "./../TD[@class='string-cell score-cell sortable renderable' and text()='${params."Overall Rank"}']"}
        if(params."Individual Evaluator Rating"){verify.IDChildren << "./../TD[@class='individual-score-cell renderable' and text()='${params."Individual Evaluator Rating"}']"}
        if(params."Comment Count"){verify.IDChildren << "./../TD[@class='review-string-cell renderable' and text()='${params."Comment Count"}']"}
        if(params."Vote Score"){verify.IDChildren << "./../TD[@class='idea-vote-score renderable' and text()='${params."Vote Score"}']"}
        if(params."Views"){verify.IDChildren << "./../TD[@class='idea-view-count renderable' and text()='${params."Views"}']"}
        
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)
    }
}
