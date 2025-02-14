package actions.ActionItems;

import actions.selenium.Click
import actions.ActionItems.SetGeneralEvaluationScorecardforIdeainActionItemspage
import actions.SetScorecardFields.SetMultiChoiceOneAnswer
import actions.SetScorecardFields.SetMultiChoiceMultiAnswer
import actions.SetScorecardFields.SetDropdown
import actions.SetScorecardFields.SetLongTextField
import actions.SetScorecardFields.SetShortTextField




class SetEvaluationScorecardIdeaActionItemspage{
    public void run(def params){
        //skip the tour (if there is option to take the tour)
        SetGeneralEvaluationScorecardforIdeainActionItemspage.skipTourScorecard()
    	sleep(3000)
        if(params."Multi Choice One Answer - Question"){SetMultiChoiceOneAnswer.run("Field Name":params."Multi Choice One Answer - Question", "Field Value":params."Multi Choice One - Answer(s)")}
        if(params."Multi Choice Multi Answer - Question"){SetMultiChoiceMultiAnswer.run("Field Name":params."Multi Choice Multi Answer - Question", "Field Value":params."Multi Choice Multi - Answer(s)")}
        if(params."Dropdown - Question"){SetDropdown.run("Field Name":params."Dropdown - Question", "Field Value":params."Dropdown - Answer(s)")}
        if(params."Short Text - Question"){SetShortTextField.run("Field Name":params."Short Text - Question", "Field Value":params."Short Text - Answer")}
        if(params."Long Text - Question"){SetLongTextField.run("Field Name":params."Long Text - Question", "Field Value":params."Long Text - Answer")}
       
        if(params."Submit Scorecard"==true){
            Click.run(ID:"//*[@id='commit_scorecard_button']")
        	sleep(2000)
        }
		
    }    
}
