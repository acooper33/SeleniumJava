package actions.ViewIdea;

import actions.selenium.*
    
class VerifyEvaluatorsListWithScoreonEvaluationTab{
    public void run(def params){
        
        if(params."Widget Instance Number"){
             SetFocus.run(ID:"//*[contains(@class,'fractal-widget-evaluation-instance-list')]/DIV[position()=${params."Widget Instance Number"}]//*[contains(@class,'fractal-evaluatorMember')][${params."Placement Number of Evaluator"}]//*[@class='fractal-imgWrapper']")
        } else {
            SetFocus.run(ID:"//*[contains(@class,'fractal-evaluatorMember')][${params."Placement Number of Evaluator"}]//*[@class='fractal-imgWrapper']")
        }
        assert Exists.run(ID:"//*[contains(@class,'flyover-user-name') and .='${params."Evaluator Name"}']/../../../../../..//*[@class='fractal-ranked-wrapper']/*[text()='${params."Score"}']")==1,"Error in Score" 
    }
}