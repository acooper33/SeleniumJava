package actions.ProjectRoom;

import actions.selenium.SetReactDropdown
import actions.selenium.SetText
import actions.selenium.SetReactModal
import actions.selenium.Click
import actions.selenium.SetFocus

class ProjectRoomEditTaskNote{
    public void run(def params){
        def xpath = "//DIV[@id='f-notes-comment-list']//DIV[contains(@class,'f-flyover-note-input-container')]//*[starts-with(.,'${params.Note}')]"
        println("xpath for the note to edit ${xpath}")
        if(params."Action"){
            SetFocus.run(ID:xpath+"/../..//DIV[contains(@class,'fractal-clickoutside')]")
            Click.run(ID:xpath+"/../..//DIV[contains(@class,'fractal-clickoutside')]")
            SetReactDropdown.run(Option:params."Action")
        }
        sleep(1000)
        if(params."New Note"){
            SetText.run(ID:xpath+"/../..//*[contains(@class,'f-comment-input-textarea')]",Text:params."New Note")
        }
        sleep(1000)
        if(params."Are you sure you want to delete the note?"){
			Click.run(ID:"//*[contains(@class,'footer')]//BUTTON[contains(.,'Delete')]")
        }
        sleep(1000)
        if(params."Action on Edit"){
            Click.run(ID:"//*[contains(@class,'f-actions-box')]//*[contains(@class,'fractal-button')][contains(normalize-space(.), '${params."Action on Edit"}')]")
        }
        sleep(1000)
    }
}