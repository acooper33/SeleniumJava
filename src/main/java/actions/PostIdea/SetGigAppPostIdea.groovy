package actions.PostIdea;

import actions.SetIdeaFields.SetPostIdeaAction
import actions.SetIdeaFields.SetPostIdeaAttachment
import actions.SetIdeaFields.SetPostIdeaDropdown
import actions.SetIdeaFields.SetPostIdeaImage
import actions.SetIdeaFields.SetPostIdeaRadioButton
import actions.SetIdeaFields.SetPostIdeaTag
import actions.SetIdeaFields.SetPostIdeaTextField

class SetGigAppPostIdea{
    public void run(def params){
    SetPostIdeaTextField.run("Field Name":"Job Title","Field Value":params."Job Title")
        SetPostIdeaImage.run("Field Name":"Image","Image File":params."Image File","Crop or Cancel":params."Image Crop or Cancel")
        SetPostIdeaTextField.run("Field Name":"Description of your Job","Field Value":params."Description of your Job")
        SetPostIdeaTag.run("Field Name":"Expertise Required","Tag or User Name":params."Expertise Required","Add or Remove":params."Expertise Add or Remove")
        SetPostIdeaAttachment.run("Field Name":"Attachments","Attachment File":params."Attachments File","Add or Remove":params."Attachment Add or Remove")
        SetPostIdeaTag.run("Field Name":"Tags","Tag or User Name":params."Tag Name","Add or Remove":params."Tags Add or Remove")
        SetPostIdeaDropdown.run("Field Name":"Job Type","Field Value":params."Job Type")
        SetPostIdeaRadioButton.run("Field Name":"Required Hours","Field Value":params."Required Hours")
        SetPostIdeaRadioButton.run("Field Name":"When does this job start?","Field Value":params."When does this job start?")
        SetPostIdeaTextField.run("Field Name":"Select a date for this project to start","Field Value":params."Select a date for this project to start")
        SetPostIdeaRadioButton.run("Field Name":"Job Location","Field Value":params."Job Location")
        SetPostIdeaTextField.run("Field Name":"Specify the job location.","Field Value":params."Specify the job location.")
        SetPostIdeaRadioButton.run("Field Name":"Engagement","Field Value":params."Engagement")
        SetPostIdeaTextField.run("Field Name":"Specify the job engagement.","Field Value":params."Specify the job engagement.")
        SetPostIdeaAction.run("Action":params."Action")
    }
}