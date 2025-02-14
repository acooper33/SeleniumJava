package actions.PostIdea;

import actions.SetIdeaFields.SetPostIdeaAction
import actions.SetIdeaFields.SetPostIdeaAttachment
import actions.SetIdeaFields.SetPostIdeaImage
import actions.SetIdeaFields.SetPostIdeaTag
import actions.SetIdeaFields.SetPostIdeaTextField
import actions.SetIdeaFields.SetPostIdeaDropdown
import actions.SetIdeaFields.SetPostIdeaTeamSubmissionField

class SetAccelerateAppPostIdea{
     public void run(def params){
        SetPostIdeaTextField.run("Field Name":"Company Name","Field Value":params."Company Name")
        SetPostIdeaImage.run("Field Name":"Company Logo","Image File":params."Company Logo","Crop or Cancel":params."Company Logo Crop or Cancel")
        SetPostIdeaDropdown.run("Field Name":"Submitter","Field Value":params."Team Members")
        SetPostIdeaTag.run("Field Name":"Submitter","Tag or User Name":params."Team Members User","Add or Remove":params."Team Members User Add or Remove")
        SetPostIdeaTeamSubmissionField.run("Field Value":params."Team Submission Name")
        SetPostIdeaTextField.run("Field Name":"Company Description","Field Value":params."Company Description")
        SetPostIdeaAttachment.run("Field Name":"Pitch Deck and Supporting Materials","Attachment File":params."Pitch Deck and Supporting Materials","Add or Remove":params."Pitch Deck and Supporting Materials Add or Remove")
        SetPostIdeaDropdown.run("Field Name":"Focus Area","Field Value":params."Focus Area")
        SetPostIdeaTextField.run("Field Name":"Company Website","Field Value":params."Company Website")
        SetPostIdeaTextField.run("Field Name":"Address","Field Value":params."Company's Address")
        SetPostIdeaTextField.run("Field Name":"Team Biographies","Field Value":params."Team Biographies")
        SetPostIdeaAction.run("Action":params."Action")
    }
}