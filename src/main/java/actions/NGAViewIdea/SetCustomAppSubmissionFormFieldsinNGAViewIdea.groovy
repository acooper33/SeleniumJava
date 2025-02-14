package actions.NGAViewIdea;

import actions.NGAViewIdeaFields.SetNGAViewIdeaRadioButton
import actions.NGAViewIdeaFields.SetNGAViewIdeaCheckbox
import actions.NGAViewIdea.SetNGAViewIdeaDescriptionTabTextField
import actions.NGAViewIdeaFields.SetNGAViewIdeaDropdown
import actions.common.NGAViewIdeaCommon
import actions.NGAViewIdeaFields.SetNGAViewIdeaUserSelection



class SetCustomAppSubmissionFormFieldsinNGAViewIdea{
    public void run(def params){
        NGAViewIdeaCommon.NavigateTab(Tab:"Description")
        if(params."Multiple Choice Question"){
            SetNGAViewIdeaRadioButton.run("Field Name":"Multiple Choice Question", "Field Value":params."Multiple Choice Question", "Action":params."Multiple Choice Question Action")
            sleep(2000)
        }
        if(params."Checkbox Question"){
            //SetNGAViewIdeaCheckbox.run("Field Name":"Checkbox Question", "Field Value":params."Checkbox Question", "Action":params."Checkbox Question Action")
            SetNGAViewIdeaCheckbox.run("Field Name":"Checkbox Question", "Checkbox Name":params."Checkbox Question", "Checkbox Check":params."Checkbox Check" , "Action":params."Checkbox Question Action")
            sleep(2000)
        }
        if(params."Short Answer Question"){
            SetNGAViewIdeaDescriptionTabTextField.run("Field Name":"Short Answer Question", "Field Value":params."Short Answer Question", "Action":params."Short Answer Question Action")
            sleep(2000)
        }
        if(params."Long Answer Question"){
            SetNGAViewIdeaDescriptionTabTextField.run("Field Name":"Long Answer Question", "Field Value":params."Long Answer Question", "Action":params."Long Answer Question Action")
            sleep(2000)
        }
        if(params."Dropdown Question"){
            SetNGAViewIdeaDropdown.run("Field Name":"Dropdown Question", "Field Value":params."Dropdown Question", "Action":params."Dropdown Question Action")
            sleep(2000)
        }
        if(params."Number Question"){
            SetNGAViewIdeaDescriptionTabTextField.run("Field Name":"Number Question", "Field Value":params."Number Question", "Action":params."Number Question Action")
            sleep(2000)
        }
        if(params."User Selection Question Name"){
            SetNGAViewIdeaUserSelection.run("Field Name":"User Selection Question", "User Name":params."User Selection Question Name", "Add or Remove":params."User Selection Question Add or Remove" , "Action":params."User Selection Question Action")
            sleep(2000)
        }
        if(params."Admin Only Dropdown Question"){
            SetNGAViewIdeaDropdown.run("Field Name":"Admin Only Dropdown Question", "Field Value":params."Admin Only Dropdown Question","Action":params."Admin Only Dropdown Question Action" )
            sleep(2000)
        }
        if(params."Required Short Question"){
            SetNGAViewIdeaDescriptionTabTextField.run("Field Name":"Required Short Question", "Field Value":params."Required Short Question", "Action":params."Required Short Question Action" )
            sleep(2000)
        }
    }
}