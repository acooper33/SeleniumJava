package actions.PostIdea;

import actions.SetIdeaFields.SetPostIdeaAction
import actions.SetIdeaFields.SetPostIdeaAttachment
import actions.SetIdeaFields.SetPostIdeaImage
import actions.SetIdeaFields.SetPostIdeaTag
import actions.SetIdeaFields.SetPostIdeaTextField
import actions.SetIdeaFields.SetPostIdeaRadioButton
import actions.SetIdeaFields.SetPostIdeaDropdown

class SetVentureAppPostIdea{
   public void run(def params){
        SetPostIdeaTextField.run("Field Name":"Company Name","Field Value":params."Company Name")
        SetPostIdeaImage.run("Field Name":"Company Logo","Image File":params."Company Logo","Crop or Cancel":params."Company Logo Crop or Cancel")
        SetPostIdeaTextField.run("Field Name":"Company Description","Field Value":params."Company Description")
        SetPostIdeaAttachment.run("Field Name":"Pitch Deck and Supporting Materials","Attachment File":params."Pitch Deck and Supporting Materials","Add or Remove":params."Pitch Deck and Supporting Materials Add or Remove")
        SetPostIdeaTag.run("Field Name":"Tags","Tag or User Name":params."Tags","Add or Remove":params."Tags Add or Remove") 
       	SetPostIdeaDropdown.run("Field Name":"Focus Area","Field Value":params."Focus Area")
        SetPostIdeaTextField.run("Field Name":"Company Website","Field Value":params."Company Website")
       	SetPostIdeaTextField.run("Field Name":"Company Address","Field Value":params."Company Address")
       	SetPostIdeaRadioButton.run("Field Name":"Is this company actively looking for funding?","Field Value":params."Is this company actively looking for funding?")
       	SetPostIdeaTextField.run("Field Name":"Amount of capital company is seeking","Field Value":params."Amount of capital company is seeking") 
       	SetPostIdeaTextField.run("Field Name":"Estimated Pre-Funding Valuation","Field Value":params."Estimated Pre-Funding Valuation") 
       	SetPostIdeaTextField.run("Field Name":"Leadership Biographies","Field Value":params."Leadership Biographies") 
        SetPostIdeaTextField.run("Field Name":"Primary Contact Name","Field Value":params."Primary Contact Name")
       	SetPostIdeaTextField.run("Field Name":"Primary Contact Email Address","Field Value":params."Primary Contact Email Address")
       	SetPostIdeaTextField.run("Field Name":"Primary Contact Phone Number","Field Value":params."Primary Contact Phone Number")
       	SetPostIdeaTextField.run("Field Name":"Primary Contact Social Media Sites","Field Value":params."Primary Contact Social Media Sites")
       	SetPostIdeaAction.run("Action":params."Action")
    }
}