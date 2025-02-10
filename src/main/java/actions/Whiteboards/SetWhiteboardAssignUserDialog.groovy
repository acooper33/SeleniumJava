package actions.Whiteboards;

import actions.selenium.SetReactModal
import actions.selenium.SetReactTags

class SetWhiteboardAssignUserDialog{
    public void run(def params){
        params."User(s)".split(",").each{
            SetReactTags.setMemberTagsWithAddRemove("Field Name":"Choose user", User:it, "Add or Remove":"Add")
        }
        SetReactModal.setModalActionButton("Modal xPath":"//DIV[contains(@class,'f-assign-modal')]", Action:params.Action)
    }
}