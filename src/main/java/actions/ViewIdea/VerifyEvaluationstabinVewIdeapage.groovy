package actions.ViewIdea;

import actions.common.ViewIdeaCommon
import actions.selenium.Exists

class VerifyEvaluationstabinVewIdeapage{
    public void run(def params){

        ViewIdeaCommon.NavigateTab(Tab:"Evaluations")

        if(params."Overall Score"){
            assert Exists.run(ID:"//*[@id='evaluationTab-content']//SPAN[@class='figure' and text()='${params."Overall Score"}']")==1,"Error - Score incorrect"
        }
        if(params."Total Evaluation"){
            assert Exists.run(ID:"//*[@id='evaluationTab-content']//SPAN[@class='smallerText' and contains(.,'${params."Total Evaluation"}')]")==1,"Error - Total Evaluation incorrect"
        }
        if(params."Completed Evaluation"){
            assert Exists.run(ID:"//*[@id='evaluationTab-content']//SPAN[@class='figure' and text()='${params."Completed Evaluation"}']")==1,"Error - Completed Evaluation incorrect"
        }
    }
}