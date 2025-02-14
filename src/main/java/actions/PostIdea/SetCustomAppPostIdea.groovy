package actions.PostIdea;

import actions.selenium.ExplicitWait
import actions.SetIdeaFields.SetPostIdeaAction
import actions.SetIdeaFields.SetPostIdeaAttachment
import actions.SetIdeaFields.SetPostIdeaCheckbox
import actions.SetIdeaFields.SetPostIdeaDropdown
import actions.SetIdeaFields.SetPostIdeaImage
import actions.SetIdeaFields.SetPostIdeaRadioButton
import actions.SetIdeaFields.SetPostIdeaTag
import actions.SetIdeaFields.SetPostIdeaTextField
import actions.SetIdeaFields.SetPostIdeaUserSelection
import actions.SetIdeaFields.SetPostIdeaTeamSubmissionField

class SetCustomAppPostIdea{
    public void run(def params){
        
        if(params."Wait for Page to Load" == true){
           ExplicitWait.run(ID:"//*[@id='form-section']") 
        }
        if(params."Only upload attachment"==null || params."Only upload attachment"==false){
            SetPostIdeaTextField.run("Field Name":"Title","Field Value":params."Title")
            SetPostIdeaTextField.run("Field Name":"Title With Emoji","Field Value":params."Title With Emoji")
        	SetPostIdeaImage.run("Field Name":"Image","Image File":params."Image File","Crop or Cancel":params."Image Crop or Cancel")
        	SetPostIdeaDropdown.run("Field Name":"Submitter","Field Value":params."Submitter")
        	SetPostIdeaTag.run("Field Name":"Submitter","Tag or User Name":params."Submitter Team User","Add or Remove":params."Submitter Team User Add or Remove")
        	SetPostIdeaTeamSubmissionField.run("Field Value":params."Team Submission Name")
        	SetPostIdeaTextField.run("Field Name":"Description","Field Value":params."Description")
        	SetPostIdeaTag.run("Field Name":"Expertise","Tag or User Name":params."Expertise","Add or Remove":params."Expertise Add or Remove")
        	SetPostIdeaAttachment.run("Field Name":"Attachments","Attachment File":params."Attachments File","Add or Remove":params."Attachment Add or Remove","Wait for Attachment to load":params."Wait for Attachment to load")
        	SetPostIdeaTag.run("Field Name":"Tags","Tag or User Name":params."Tag Name","Add or Remove":params."Tag Add or Remove")
        	SetPostIdeaDropdown.run("Field Name":"Category","Field Value":params."Category")
        	SetPostIdeaRadioButton.run("Field Name":"Multiple Choice Question","Field Value":params."Multiple Choice Question")
        	SetPostIdeaCheckbox.run("Field Name":"Checkbox Question","Checkbox Name":params."Checkbox Question Name","Check":params."Checkbox Check")
        	SetPostIdeaTextField.run("Field Name":"Short Answer Question","Field Value":params."Short Answer Question")
        	SetPostIdeaTextField.run("Field Name":"Long Answer Question","Field Value":params."Long Answer Question")
        	SetPostIdeaDropdown.run("Field Name":"Dropdown Question","Field Value":params."Dropdown Question")
        	SetPostIdeaTextField.run("Field Name":"Date Question","Field Value":params."Date Question")
        	SetPostIdeaTextField.run("Field Name":"Number Question","Field Value":params."Number Question")
        	SetPostIdeaTag.run("Field Name":"User Selection Question","Tag or User Name":params."User Selection Question Name","Add or Remove":params."User Selection Question Add or Remove")
        	SetPostIdeaDropdown.run("Field Name":"Admin Only Dropdown Question","Field Value":params."Admin Only Dropdown Question")
        	SetPostIdeaTextField.run("Field Name":"Required Short Question","Field Value":params."Required Short Question")
            sleep(2000)
            SetPostIdeaAction.run("Action":params."Action")
        } else{
          SetPostIdeaAttachment.run("Field Name":"Attachments","Attachment File":params."Attachments File","Add or Remove":params."Attachment Add or Remove","Wait for Attachment to load":params."Wait for Attachment to load")  
        }
    }
}