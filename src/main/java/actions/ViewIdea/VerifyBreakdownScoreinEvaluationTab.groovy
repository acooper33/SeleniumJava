package actions.ViewIdea;

import actions.selenium.*

class VerifyBreakdownScoreinEvaluationTab{
    public void run(def params){

        if(params."Breakdown"){
            assert Exists.run(ID:"//*[@class='breakdown-scorecard-title' and contains(.,'${params."Breakdown"}')]")==1,"Error in Breakdown"
        }
        if(Exists.run(ID:"//*[@class='breakdown-scorecard-title' and contains(.,'${params."Breakdown"}')]/../..//*[@class='show-breakdown-btn']//*[contains(@class,'fa-plus-square')]") == 1){
            Click.run(ID:"//*[@class='breakdown-scorecard-title' and contains(.,'${params."Breakdown"}')]/../..//*[@class='show-breakdown-btn']//*[contains(@class,'fa-plus-square')]", "Type of Click": "Javascript")
            sleep(2000)
        }
        if(params."Points"){
            assert Exists.run(ID:"//*[contains(@class,'fractal-eval-table-cell fractal-eval-question-col') and contains(.,'${params."Question"}')]/parent::DIV//*[@class='fractal-eval-table-cell fractal-eval-points-col' and contains(.,'${params."Points"}')]")==1,"Error in Points"
        }
    }
}