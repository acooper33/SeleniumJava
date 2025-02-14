package actions.PostIdea;

import actions.SetIdeaFields.SetPostIdeaAction
import actions.SetIdeaFields.SetPostIdeaAttachment
import actions.SetIdeaFields.SetPostIdeaImage
import actions.SetIdeaFields.SetPostIdeaTag
import actions.SetIdeaFields.SetPostIdeaTextField
import actions.SetIdeaFields.SetPostIdeaDropdown
import actions.SetIdeaFields.SetPostIdeaTeamSubmissionField

class SetHackAppPostIdea{
    public void run(def params){
        SetPostIdeaTextField.run("Field Name":"Title","Field Value":params."Title")
        SetPostIdeaImage.run("Field Name":"Image","Image File":params."Image File","Crop or Cancel":params."Image Crop or Cancel")
        SetPostIdeaDropdown.run("Field Name":"Submitter","Field Value":params."Submitter")
        SetPostIdeaTag.run("Field Name":"Submitter","Tag or User Name":params."Submitter Team User","Add or Remove":params."Submitter Team User Add or Remove")
        SetPostIdeaTeamSubmissionField.run("Field Value":params."Team Submission Name")
        SetPostIdeaTextField.run("Field Name":"Description","Field Value":params."Description")
        SetPostIdeaDropdown.run("Field Name":"Category","Field Value":params."Category")
        SetPostIdeaTag.run("Field Name":"Expertise Required","Tag or User Name":params."Expertise","Add or Remove":params."Expertise Add or Remove")
        SetPostIdeaAttachment.run("Field Name":"Attachments","Attachment File":params."Attachments File","Add or Remove":params."Attachment Add or Remove")
        SetPostIdeaTag.run("Field Name":"Tags","Tag or User Name":params."Tag Name","Add or Remove":params."Tags Add or Remove")
        SetPostIdeaTextField.run("Field Name":"What problem are you addressing with your project?","Field Value":params."What problem are you addressing with your project?")
        SetPostIdeaTextField.run("Field Name":"Please describe the technologies being used in your project.","Field Value":params."Please describe the technologies being used in your project.")
        SetPostIdeaAction.run("Action":params."Action")
    }
}