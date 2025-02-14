package actions.ProjectRoom;

import actions.POMHelperAndLocators.FormElements.SetReactDropdownField
import actions.POMHelperAndLocators.FormElements.SetReactLongTextField
import actions.POMHelperAndLocators.FormElements.SetReactShortTextField
import actions.POMHelperAndLocators.FormElements.SetReactMultiChoiceMultiAnswer
import actions.POMHelperAndLocators.FormElements.SetReactMultiChoiceOneAnswer
import actions.selenium.Click

class SetCustomGateApprovalActionItem{
     public void run(def params){
         
        if(params."Multi Choice One Answer - Question"){SetReactMultiChoiceOneAnswer.run("Field Name":params."Multi Choice One Answer - Question", "Field Value":params."Multi Choice One - Answer(s)")}
        if(params."Multi Choice Multi Answer - Question"){SetReactMultiChoiceMultiAnswer.run("Field Name":params."Multi Choice Multi Answer - Question", "Field Value":params."Multi Choice Multi - Answer(s)","Check or Uncheck checkbox":params."Multi Choice Multi - Answer(s) check or uncheck")}
        if(params."Dropdown - Question"){SetReactDropdownField.run("Field Name":params."Dropdown - Question", "Field Value":params."Dropdown - Answer(s)")}
        if(params."Short Text - Question"){SetReactShortTextField.run("Field Name":params."Short Text - Question", "Field Value":params."Short Text - Answer")}
        if(params."Long Text - Question"){SetReactLongTextField.run("Field Name":params."Long Text - Question", "Field Value":params."Long Text - Answer")}
       
        if(params."Submit Action Item"==true){
            sleep(2000)
            Click.run(ID:"//button[normalize-space()='Complete Gate']")
        	sleep(2000)
        }
		
    }    
}
