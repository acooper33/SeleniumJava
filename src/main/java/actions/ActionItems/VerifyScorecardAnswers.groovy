package actions.ActionItems;

import actions.SetScorecardFields.VerifyMultiChoiceOneAnswer
import actions.SetScorecardFields.VerifyDropdown
import actions.SetScorecardFields.VerifyTextField

class VerifyScorecardAnswers{
    public void run(def params){
      	if(params."Multi Choice One Answer - Question"){VerifyMultiChoiceOneAnswer.run("Field Name":params."Multi Choice One Answer - Question", "Field Value":params."Multi Choice One - Answer(s)","Question Type":"radio_label")}
        if(params."Multi Choice Multi Answer - Question"){VerifyMultiChoiceOneAnswer.run("Field Name":params."Multi Choice Multi Answer - Question", "Field Value":params."Multi Choice Multi - Answer(s)", "Question Type":"checkbox_label")}
        if(params."Dropdown - Question"){VerifyDropdown.run("Field Name":params."Dropdown - Question","Field Value":params."Dropdown - Answer(s)")}
        if(params."Long Text - Question"){VerifyTextField.run("Field Name":params."Long Text - Question","Field Value":params."Long Text - Answer","Question Type":"eval_question_long")}
        if(params."Short Text - Question"){VerifyTextField.run("Field Name":params."Short Text - Question","Field Value":params."Short Text - Answer","Question Type":"eval_quesiton_short")}
        
    }
}