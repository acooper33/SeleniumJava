package actions.PostIdea;

import actions.SetIdeaFields.SetPostIdeaAction
import actions.SetIdeaFields.SetPostIdeaAttachment
import actions.SetIdeaFields.SetPostIdeaImage
import actions.SetIdeaFields.SetPostIdeaTag
import actions.SetIdeaFields.SetPostIdeaTextField
import actions.SetIdeaFields.SetPostIdeaDropdown
import actions.SetIdeaFields.SetPostIdeaTeamSubmissionField

class SetApplyAppPostIdea{
    public void run(def params){
      	SetPostIdeaTextField.run("Field Name":"Title","Field Value":params."Title")
        SetPostIdeaImage.run("Field Name":"Image","Image File":params."Image File","Crop or Cancel":params."Image Crop or Cancel")
        SetPostIdeaDropdown.run("Field Name":"Submitter","Field Value":params."Submitter")
        SetPostIdeaTag.run("Field Name":"Submitter","Tag or User Name":params."Submitter Team User","Add or Remove":params."Submitter Team User Add or Remove")
        SetPostIdeaTeamSubmissionField.run("Field Value":params."Team Submission Name")
        SetPostIdeaTextField.run("Field Name":"Description","Field Value":params."Description")
        SetPostIdeaAttachment.run("Field Name":"Attachments","Attachment File":params."Attachments File","Add or Remove":params."Attachment Add or Remove")
        SetPostIdeaTag.run("Field Name":"Tags","Tag or User Name":params."Tag Name","Add or Remove":params."Tags Add or Remove")
        SetPostIdeaDropdown.run("Field Name":"Category","Field Value":params."Category")
        SetPostIdeaTextField.run("Field Name":"How would this create value for our business?","Field Value":params."How would this create value for our business?")
        SetPostIdeaTextField.run("Field Name":"What resources or expertise would be required to apply this technology to your idea?","Field Value":params."What resources or expertise would be required to apply this technology to your idea?")
        SetPostIdeaTextField.run("Field Name":"Are there competitors that have already used this application of the technology?","Field Value":params."Are there competitors that have already used this application of the technology?")
        SetPostIdeaTextField.run("Field Name":"Why do you think this should be the first, and best, application of this technology for our business?","Field Value":params."Why do you think this should be the first, and best, application of this technology for our business?")
        SetPostIdeaAction.run("Action":params."Action")
    }
}