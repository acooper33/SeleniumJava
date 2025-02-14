package actions.PostIdea;

import actions.SetIdeaFields.SetPostIdeaAction
import actions.SetIdeaFields.SetPostIdeaAttachment
import actions.SetIdeaFields.SetPostIdeaImage
import actions.SetIdeaFields.SetPostIdeaTag
import actions.SetIdeaFields.SetPostIdeaTextField

class SetExploreAppPostIdea{
    public void run(def params){
      	SetPostIdeaTextField.run("Field Name":"Title","Field Value":params."Title")
        SetPostIdeaImage.run("Field Name":"Image","Image File":params."Image File","Crop or Cancel":params."Image Crop or Cancel")
       	SetPostIdeaTextField.run("Field Name":"Description","Field Value":params."Description")
        SetPostIdeaAttachment.run("Field Name":"Attachments","Attachment File":params."Attachments File","Add or Remove":params."Attachment Add or Remove")
        SetPostIdeaTag.run("Field Name":"Tags","Tag or User Name":params."Tag Name","Add or Remove":params."Tags Add or Remove")
        SetPostIdeaTextField.run("Field Name":"What would be the value for the target customer?","Field Value":params."What would be the value for the target customer?")
        SetPostIdeaTextField.run("Field Name":"What would be the value for our business?","Field Value":params."What would be the value for our business?")
        SetPostIdeaTextField.run("Field Name":"What resources or expertise would be required to pursue this idea?","Field Value":params."What resources or expertise would be required to pursue this idea?")
        SetPostIdeaTextField.run("Field Name":"What key activities are required to pursue this idea successfully?","Field Value":params."What key activities are required to pursue this idea successfully?")
        SetPostIdeaTextField.run("Field Name":"What competitors offer something similar?","Field Value":params."What competitors offer something similar?")
        SetPostIdeaAction.run("Action":params."Action")
    }
}