package actions.PostIdea;

import actions.SetIdeaFields.SetPostIdeaAction
import actions.SetIdeaFields.SetPostIdeaAttachment
import actions.SetIdeaFields.SetPostIdeaImage
import actions.SetIdeaFields.SetPostIdeaTag
import actions.SetIdeaFields.SetPostIdeaTextField
import actions.SetIdeaFields.SetPostIdeaDropdown
import actions.SetIdeaFields.SetPostIdeaCheckbox

class SetMonitorAppPostIdea{
    public void run(def params){
        
     	SetPostIdeaTextField.run("Field Name":"Title","Field Value":params."Title")
        SetPostIdeaImage.run("Field Name":"Image","Image File":params."Image","Crop or Cancel":params."Image Crop or Cancel")
        SetPostIdeaTextField.run("Field Name":"Description","Field Value":params."Description")
        SetPostIdeaAttachment.run("Field Name":"Attachments","Attachment File":params."Attachments","Add or Remove":params."Attachments Add or Remove")
        SetPostIdeaTag.run("Field Name":"Tags","Tag or User Name":params."Tags","Add or Remove":params."Tags Add or Remove")
        SetPostIdeaAction.run("Action":params."Action")
    }
}