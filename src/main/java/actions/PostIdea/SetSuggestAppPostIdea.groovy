package actions.PostIdea;

import actions.SetIdeaFields.SetPostIdeaAction
import actions.SetIdeaFields.SetPostIdeaAttachment
import actions.SetIdeaFields.SetPostIdeaImage
import actions.SetIdeaFields.SetPostIdeaTag
import actions.SetIdeaFields.SetPostIdeaTextField
import actions.SetIdeaFields.SetPostIdeaDropdown
import actions.SetIdeaFields.SetPostIdeaCheckbox

class SetSuggestAppPostIdea{
   public void run(def params){
        SetPostIdeaTextField.run("Field Name":"Title","Field Value":params."Title")
        SetPostIdeaImage.run("Field Name":"Image","Image File":params."Image","Crop or Cancel":params."Image Crop or Cancel")
        SetPostIdeaTextField.run("Field Name":"Description","Field Value":params."Description")
        SetPostIdeaAttachment.run("Field Name":"Attachments","Attachment File":params."Attachments","Add or Remove":params."Attachments Add or Remove")
        SetPostIdeaTag.run("Field Name":"Tags","Tag or User Name":params."Tags","Add or Remove":params."Tags Add or Remove")
        SetPostIdeaDropdown.run("Field Name":"Category","Field Value":params."Category")
       	SetPostIdeaTextField.run("Field Name":"Describe the problem or issue that this idea is addressing.","Field Value":params."Describe the problem or issue that this idea is addressing.")
        SetPostIdeaCheckbox.run("Field Name":"What benefit(s) will result from implementing this idea? Please select all that apply.","Checkbox Name":params."Benefit Name","Check":params."Checkbox Check")
        SetPostIdeaAction.run("Action":params."Action")
    }
}