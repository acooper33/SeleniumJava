package actions.PostIdea;

import actions.SetIdeaFields.SetPostIdeaAction
import actions.SetIdeaFields.SetPostIdeaAttachment
import actions.SetIdeaFields.SetPostIdeaImage
import actions.SetIdeaFields.SetPostIdeaTag
import actions.SetIdeaFields.SetPostIdeaTextField
import actions.SetIdeaFields.SetPostIdeaDropdown

class SetConsultAppPostIdea{
    public void run(def params){
        SetPostIdeaTextField.run("Field Name":"Project Title","Field Value":params."Project Title")
        SetPostIdeaImage.run("Field Name":"Image","Image File":params."Image","Crop or Cancel":params."Image Crop or Cancel")
        SetPostIdeaTextField.run("Field Name":"Description of your project","Field Value":params."Description of your project")
        SetPostIdeaTag.run("Field Name":"Expertise Required","Tag or User Name":params."Expertise Required","Add or Remove":params."Expertise Required Add or Remove")
        SetPostIdeaAttachment.run("Field Name":"Attachments","Attachment File":params."Attachments","Add or Remove":params."Attachments Add or Remove")
        SetPostIdeaTag.run("Field Name":"Tags","Tag or User Name":params."Tags","Add or Remove":params."Tags Add or Remove")
        SetPostIdeaDropdown.run("Field Name":"Department","Field Value":params."Department")
        SetPostIdeaTextField.run("Field Name":"How can our team help you with your project?","Field Value":params."How can our team help you with your project?")
        SetPostIdeaAction.run("Action":params."Action")
    }
}