package actions.PipelineStepsView;

import actions.selenium.Exists
import actions.selenium.*

class VerifyResulttooltipinPipelineStepsView{
    public void run(def params){
        
        MouseOver.run(ID:"//DIV[@id='content-inside']/DIV[contains(@class,'content-id')]/P[contains(.,'${params."Idea"}')]/../../../..//DIV[@class='eval-results-square']")
        if(params."Message"){
            assert Exists.run(ID:"//*[contains(@class,'qtip-rounded qtip-pos-bc qtip-fixed') and contains(@style,'display: block')]//*[@class='result-tooltip']/*[text()='${params."Message"}']")==1, "Error - 'Incorrect message displayed"
        }
        if(params."View Results"){
            if(params."View Results"==true){
                Click.run(ID:"//*[contains(@class,'qtip-rounded qtip-pos-bc qtip-fixed') and contains(@style,'display: block')]//A")
            }
        }
    }
}