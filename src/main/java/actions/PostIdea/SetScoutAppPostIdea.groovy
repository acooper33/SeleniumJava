package actions.PostIdea;

import actions.SetIdeaFields.SetPostIdeaAction
import actions.SetIdeaFields.SetPostIdeaAttachment
import actions.SetIdeaFields.SetPostIdeaImage
import actions.SetIdeaFields.SetPostIdeaTag
import actions.SetIdeaFields.SetPostIdeaTextField
import actions.SetIdeaFields.SetPostIdeaDropdown
import actions.SetIdeaFields.SetPostIdeaRadioButton
import actions.SetIdeaFields.SetPostIdeaTeamSubmissionField

class SetScoutAppPostIdea{
    public void run(def params){
        SetPostIdeaTextField.run("Field Name":"Company Name","Field Value":params."Company Name")
        SetPostIdeaImage.run("Field Name":"Company Logo or Image","Image File":params."Company Logo or Image","Crop or Cancel":params."Image Crop or Cancel")
        SetPostIdeaDropdown.run("Field Name":"Submitter","Field Value":params."Submitter")
        SetPostIdeaTag.run("Field Name":"Submitter","Tag or User Name":params."Submitter Team User","Add or Remove":params."Submitter Team User Add or Remove")
        SetPostIdeaTeamSubmissionField.run("Field Value":params."Team Submission Name")
        SetPostIdeaTextField.run("Field Name":"Company Description","Field Value":params."Company Description")
        SetPostIdeaAttachment.run("Field Name":"Pitch Deck and Supporting Materials","Attachment File":params."Pitch Deck and Supporting Materials","Add or Remove":params."Pitch Deck and Supporting Materials Add or Remove")
        SetPostIdeaTag.run("Field Name":"Tags","Tag or User Name":params."Tag Name","Add or Remove":params."Tag Add or Remove")
        SetPostIdeaDropdown.run("Field Name":"Category","Field Value":params."Category")
        SetPostIdeaTextField.run("Field Name":"Company Website","Field Value":params."Company Website")
        SetPostIdeaRadioButton.run("Field Name":"Company Size","Field Value":params."Company Size")
        SetPostIdeaTextField.run("Field Name":"Company Headquarters Address","Field Value":params."Company Headquarters Address")
        SetPostIdeaTextField.run("Field Name":"Company Crunch Base Profile","Field Value":params."Company Crunch Base Profile")
        SetPostIdeaTextField.run("Field Name":"Primary Contact Name","Field Value":params."Primary Contact Name")
        SetPostIdeaTextField.run("Field Name":"Primary Contact Title and Department","Field Value":params."Primary Contact Title and Department")
        SetPostIdeaTextField.run("Field Name":"Primary Contact Email Address","Field Value":params."Primary Contact Email Address")
        SetPostIdeaTextField.run("Field Name":"Primary Contact Phone Number","Field Value":params."Primary Contact Phone Number")
        SetPostIdeaRadioButton.run("Field Name":"Funding Round","Field Value":params."Funding Round")
        SetPostIdeaRadioButton.run("Field Name":"Total Funding","Field Value":params."Total Funding")
        SetPostIdeaTextField.run("Field Name":"Investors","Field Value":params."Investors")
        SetPostIdeaTextField.run("Field Name":"Known Competitors","Field Value":params."Known Competitors")
        SetPostIdeaDropdown.run("Field Name":"How did you hear about this company?","Field Value":params."How did you hear about this company?")
        SetPostIdeaRadioButton.run("Field Name":"How would we acquire the technology from this company?","Field Value":params."How would we acquire the technology from this company?")
        SetPostIdeaTextField.run("Field Name":"Who are the team members responsible for owning this opportunity?","Field Value":params."Who are the team members responsible for owning this opportunity?")
        SetPostIdeaAction.run("Action":params."Action")
    }
}