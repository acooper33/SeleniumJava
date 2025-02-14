package actions.PostIdea;

import actions.SetIdeaFields.SetPostIdeaAction
import actions.SetIdeaFields.SetPostIdeaAttachment
import actions.SetIdeaFields.SetPostIdeaImage
import actions.SetIdeaFields.SetPostIdeaTag
import actions.SetIdeaFields.SetPostIdeaTextField

class SetSolveAppPostIdea{
    public void run(def params){
        SetPostIdeaTextField.run("Field Name":"Title","Field Value":params."Title")
        SetPostIdeaImage.run("Field Name":"Image","Image File":params."Image File","Crop or Cancel":params."Image Crop or Cancel")
        SetPostIdeaTextField.run("Field Name":"Description","Field Value":params."Description")
        SetPostIdeaAttachment.run("Field Name":"Attachments","Attachment File":params."Attachments File","Add or Remove":params."Attachment Add or Remove")
        SetPostIdeaTag.run("Field Name":"Tags","Tag or User Name":params."Tags","Add or Remove":params."Tags Add or Remove")
        SetPostIdeaTextField.run("Field Name":"Please describe how this solution addresses the problem.","Field Value":params."Please describe how this solution addresses the problem.")
        SetPostIdeaAction.run("Action":params."Action")
    }
}