package actions.PostIdea;

import actions.SetIdeaFields.SetPostIdeaAction
import actions.SetIdeaFields.SetPostIdeaAttachment
import actions.SetIdeaFields.SetPostIdeaImage
import actions.SetIdeaFields.SetPostIdeaTag
import actions.SetIdeaFields.SetPostIdeaTextField
import actions.SetIdeaFields.SetPostIdeaDropdown

class SetTransformAppPostIdea{
     public void run(def params){
        SetPostIdeaTextField.run("Field Name":"Title","Field Value":params."Title")
        SetPostIdeaImage.run("Field Name":"Image","Image File":params."Image","Crop or Cancel":params."Image Crop or Cancel")
        SetPostIdeaTextField.run("Field Name":"Description","Field Value":params."Description")
        SetPostIdeaAttachment.run("Field Name":"Attachments","Attachment File":params."Attachments","Add or Remove":params."Attachments Add or Remove")
        SetPostIdeaDropdown.run("Field Name":"Project type","Field Value":params."Project type")
        SetPostIdeaTextField.run("Field Name":"What department/business unit(s) does this project affect?","Field Value":params."What department/business unit(s) does this project affect?")
        SetPostIdeaTextField.run("Field Name":"Describe the benefit of implementing this project.","Field Value":params."Describe the benefit of implementing this project.")
        SetPostIdeaAction.run("Action":params."Action")
    }
}