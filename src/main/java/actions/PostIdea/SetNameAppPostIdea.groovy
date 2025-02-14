package actions.PostIdea;

import actions.SetIdeaFields.SetPostIdeaAction
import actions.SetIdeaFields.SetPostIdeaAttachment
import actions.SetIdeaFields.SetPostIdeaImage
import actions.SetIdeaFields.SetPostIdeaTag
import actions.SetIdeaFields.SetPostIdeaTextField

class SetNameAppPostIdea{
    public void run(def params){
        SetPostIdeaTextField.run("Field Name":"Name","Field Value":params."Name")
        SetPostIdeaImage.run("Field Name":"Image","Image File":params."Image File","Crop or Cancel":params."Image Crop or Cancel")
        SetPostIdeaTextField.run("Field Name":"Please add any information as to why your name would be best.","Field Value":params."Please add any information as to why your name would be best.")
        SetPostIdeaAttachment.run("Field Name":"Attachments","Attachment File":params."Attachments File","Add or Remove":params."Attachment Add or Remove")
        SetPostIdeaAction.run("Action":params."Action")
    }
}