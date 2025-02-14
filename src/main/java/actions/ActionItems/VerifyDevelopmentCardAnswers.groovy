package actions.ActionItems;

import actions.SetDevelopmentFields.VerifyDevMultiChoice
import actions.SetDevelopmentFields.VerifyDevTextField



class VerifyDevelopmentCardAnswers{
    public void run(def params){
        if(params."Checkbox Question - Title"){VerifyDevMultiChoice.run("Field Title":params."Checkbox Question - Title", "Field Value":params."Checkbox Question - Answer(s)")}
        if(params."Date Question - Title"){VerifyDevTextField.run("Field Title":params."Date Question - Title", "Field Value":params."Date Question - Answer", "Question Type":"date")}
        if(params."Multiple Choice - Title"){VerifyDevMultiChoice.run("Field Title":params."Multiple Choice - Title", "Field Value":params."Multiple Choice - Answer")}
        if(params."Number Question - Title"){VerifyDevTextField.run("Field Title":params."Number Question - Title", "Field Value":params."Number Question - Answer", "Question Type":"date")}
        if(params."Dropdown - Title"){VerifyDevTextField.run("Field Title":params."Dropdown - Title", "Field Value":params."Dropdown - Value", "Question Type":"dropdown")}
        if(params."Short Answer - Title"){VerifyDevTextField.run("Field Title":params."Short Answer - Title", "Field Value":params."Short Answer - Answer", "Question Type":"short")}
        if(params."Long Answer - Title"){VerifyDevTextField.run("Field Title":params."Long Answer - Title", "Field Value":params."Long Answer - Answer", "Question Type":"long")}
        if(params."User Selection - Title"){VerifyDevTextField.run("Field Title":params."User Selection - Title", "Field Value":params."User Selection - Answer","User Pic":params."User Selection Profile Pic Exists","Question Type":"user")}
    }
}