package actions.PostIdea;

import actions.SetIdeaFields.SetPostIdeaAction
import actions.SetIdeaFields.SetPostIdeaAttachment
import actions.SetIdeaFields.SetPostIdeaImage
import actions.SetIdeaFields.SetPostIdeaTag
import actions.SetIdeaFields.SetPostIdeaTextField
import actions.SetIdeaFields.SetPostIdeaDropdown
import actions.SetIdeaFields.SetPostIdeaTeamSubmissionField

class SetPitchAppPostIdea{
    public void run(def params){
        SetPostIdeaTextField.run("Field Name":"Title","Field Value":params."Title")
        SetPostIdeaImage.run("Field Name":"Image","Image File":params."Image File","Crop or Cancel":params."Image Crop or Cancel")
        SetPostIdeaDropdown.run("Field Name":"Submitter","Field Value":params."Submitter")
        SetPostIdeaTag.run("Field Name":"Submitter","Tag or User Name":params."Submitter Team User","Add or Remove":params."Submitter Team User Add or Remove")
        SetPostIdeaTeamSubmissionField.run("Field Value":params."Team Submission Name")
        SetPostIdeaTextField.run("Field Name":"Description","Field Value":params."Description")
        SetPostIdeaAttachment.run("Field Name":"Attachments","Attachment File":params."Attachments File","Add or Remove":params."Attachment Add or Remove")
        SetPostIdeaTag.run("Field Name":"Tags","Tag or User Name":params."Tags","Add or Remove":params."Tags Add or Remove")
        SetPostIdeaTextField.run("Field Name":"What is the value proposition?","Field Value":params."What is the value proposition?")
        SetPostIdeaTextField.run("Field Name":"What problem are you solving?","Field Value":params."What problem are you solving?")
        SetPostIdeaTextField.run("Field Name":"What key resources does your proposal require?","Field Value":params."What key resources does your proposal require?")
        SetPostIdeaTextField.run("Field Name":"Who are the key stakeholders in executing your proposal?","Field Value":params."Who are the key stakeholders in executing your proposal?")
        SetPostIdeaTextField.run("Field Name":"What are the key risks of executing your proposal?","Field Value":params."What are the key risks of executing your proposal?")
        SetPostIdeaTextField.run("Field Name":"Please describe your","Field Value":params."Please describe your (team's) background and experience")
        SetPostIdeaAction.run("Action":params."Action")
        
    }
}