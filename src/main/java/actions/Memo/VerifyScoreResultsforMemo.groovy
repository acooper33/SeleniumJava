package actions.Memo;

import actions.selenium.MouseOver
import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Click
import actions.selenium.SetFocus

class VerifyScoreResultsforMemo{
    public void run(def params){
        
        SetFocus.run(ID:"//DIV[contains(@class,'f-idea f-idea-large')]//DIV[contains(@class,'f-idea-title')]/SPAN[contains(.,'${params."Title"}')]/../..//*[contains(@class,'f-round-score-container')]")
        MouseOver.run(ID:"//DIV[contains(@class,'f-idea f-idea-large')]//DIV[contains(@class,'f-idea-title')]/SPAN[contains(.,'${params."Title"}')]/../..//*[contains(@class,'f-round-score-container')]")
        def verify = [:]
      	verify.ID = "//DIV[contains(@class,'show border place-bottom type-custom allow_click f-results-square-tip')]//*[@class='f-memo-results-tooltip']"
          
        verify.IDChildren = []
    	if(params."Round Name"){verify.IDChildren << ".//*[@class='f-memo-review' and text()='${params."Round Name"}']"}
    	if(params."Progress Bar Step count"){verify.IDChildren << ".//*[@class='f-progress-bar']/DIV[${params."Progress Bar Step count"}]"}
    	if(params."Completed Count"){verify.IDChildren << ".//*[@class='f-completed' and text()='${params."Completed Count"}']"}
   
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)
    
    	if(params."Click on View Results"==true) {
            Click.run(ID:verify.ID+"//A")  
        }
    }
}
