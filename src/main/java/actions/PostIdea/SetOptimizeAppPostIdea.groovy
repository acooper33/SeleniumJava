package actions.PostIdea;

import actions.SetIdeaFields.SetPostIdeaAction
import actions.SetIdeaFields.SetPostIdeaAttachment
import actions.SetIdeaFields.SetPostIdeaImage
import actions.SetIdeaFields.SetPostIdeaTag
import actions.SetIdeaFields.SetPostIdeaTextField
import actions.SetIdeaFields.SetPostIdeaTeamSubmissionField
import actions.SetIdeaFields.SetPostIdeaDropdown


class SetOptimizeAppPostIdea{
    public void run(def params){
        
        SetPostIdeaTextField.run("Field Name":"Title","Field Value":params."Title")
        SetPostIdeaImage.run("Field Name":"Image","Image File":params."Image","Crop or Cancel":params."Image Crop or Cancel")
        SetPostIdeaTag.run("Field Name":"Submitter","Tag or User Name":params."Submitter Team User","Add or Remove":params."Submitter Team User Add or Remove")
        SetPostIdeaDropdown.run("Field Name":"Category","Field Value":params."Category")
        SetPostIdeaTeamSubmissionField.run("Field Value":params."Team Submission Name")
        SetPostIdeaTextField.run("Field Name":"Description","Field Value":params."Description")
        SetPostIdeaAttachment.run("Field Name":"Attachments","Attachment File":params."Attachments","Add or Remove":params."Attachments Add or Remove")
        SetPostIdeaTag.run("Field Name":"Tags","Tag or User Name":params."Tags","Add or Remove":params."Tags Add or Remove")
        SetPostIdeaTextField.run("Field Name":"Please describe the expected benefit of this improvement.","Field Value":params."Please describe the expected benefit of this improvement.")
        SetPostIdeaAction.run("Action":params."Action")
    }
}