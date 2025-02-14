package actions.ActionItems;

import actions.selenium.Click
import actions.ActionItems.SetGeneralEvaluationScorecardforIdeainActionItemspage
import actions.SetDevelopmentFields.SetDevCheckBox
import actions.SetDevelopmentFields.SetDevTextField
import actions.SetDevelopmentFields.SetDevUserSelection
import actions.SetDevelopmentFields.SetDevMultiChoice
import actions.SetDevelopmentFields.SetDevDropdown

import actions.common.AppsCommon


class SetDevelopmentActionItemPageFields{
    public void run(def params){
        //skip the tour (if there is option to take the tour)
        SetGeneralEvaluationScorecardforIdeainActionItemspage.skipTourScorecard()
    	sleep(3000)
        if(params."Checkbox Question - Title"){
            SetDevCheckBox.run("Field Title":params."Checkbox Question - Title", "Field Value":params."Checkbox Question - Answer(s)", Check:params."Checkbox Question Check")
        }
        if(params."Date Question - Title"){SetDevTextField.shortTextField("Field Title":params."Date Question - Title", "Field Value":params."Date Question - Answer")}
        if(params."Number Question - Title"){SetDevTextField.shortTextField("Field Title":params."Number Question - Title", "Field Value":params."Number Question - Answer")}
        if(params."Multiple Choice - Title"){SetDevMultiChoice.run("Field Title":params."Multiple Choice - Title", "Field Value":params."Multiple Choice - Answer")}
        if(params."Dropdown - Title"){SetDevDropdown.run("Field Title":params."Dropdown - Title", "Field Value":params."Dropdown - Value")}
        if(params."Short Answer - Title"){SetDevTextField.shortTextField("Field Title":params."Short Answer - Title", "Field Value":params."Short Answer - Answer")}
        if(params."Long Answer - Title"){SetDevTextField.longTextField("Field Title":params."Long Answer - Title", "Field Value":params."Long Answer - Answer")}
        if(params."User Selection - Title"){AppsCommon.UserPickerAddRemove("Field Name":params."User Selection - Title",User:params."User Selection - Answer","Add or Remove":params."User Selection - Add or Remove")}
        //if(params."User Selection - Title"){SetDevUserSelection.run("Field Title":params."User Selection - Title", "Field Value":params."User Selection - Answer", "Add or Remove":params."User Selection - Add or Remove")}
        if(params.Action=="Save"){Click.run(ID:"//*[@id='save']")}
        else if (params.Action=="Mark Complete" || params.Action=="Done"){
            Click.run(ID:"//*[@id='complete']")
            sleep(1000)
            Click.run(ID:"//*[@id='f-modal-submit']")
            sleep(1000)
        }
    }
}