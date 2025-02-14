package actions.TopIdeas;

import actions.selenium.Exists
import actions.selenium.*

class VerifyResultToolTipinTopIdeas{
    public void run(def params){
  
        SetFocus.run(ID:"//DIV[contains(@class,'f-idea f-idea-large')]//DIV[contains(@class,'f-idea-title')]/SPAN[contains(.,'${params."Idea"}')]/../..//*[contains(@class,'f-has-score')]")
        if(params."Message"){
            assert Exists.run(ID:"//DIV[contains(@id,'f-result-container')]/*[text()='${params."Message"}']")==1, "Error - 'Incorrect message displayed"
        }
        if(params."View Results"){
            if(params."View Results"==true){
                Click.run(ID:"//DIV[contains(@id,'f-result-container')]//A")
            }
        }
    }
}