package actions.Whiteboards;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SetFocus
import actions.selenium.SetCombobox

class WhiteboardSetAIAssist{
    public void run(def params){
        if(params."Tab"){
            Click.run(ID:"//*[contains(@class,'f-tabs-header')]//BUTTON//*[contains(.,'${params."Tab"}')]")
        }
        if(params."Task"){
            SetCombobox.run(ID:"//INPUT[@id='f-ai-task-combobox']", Option:params."Task")
            sleep(1000)
        }
        if(params."Prompt/Topic"){
        	SetFocus.run(ID:"//TEXTAREA[@id='fractal-ai-topic']")
            SetText.run(ID:"//TEXTAREA[@id='fractal-ai-topic']", Text:params."Prompt/Topic")
        }
        if(params."Style"){
            //println("setting style ${params."Style"}")
            SetCombobox.run(ID:"//INPUT[@id='f-ai-style-combobox']", Option:params."Style")
            sleep(1000)
        }
        if(params."Stickies"){
            //println("setting Stickies ${params."Stickies"}")
            SetCombobox.run(ID:"//INPUT[@id='f-ai-stickies-combobox']", Option:params."Stickies")
            sleep(1000)
        }
        if(params."Word limit"){
            //println("setting Word limit ${params."Word limit"}")
            SetCombobox.run(ID:"//INPUT[@id='f-ai-word-limit-combobox']", Option:params."Word limit")
            sleep(1000)
        }
        if(params."Sticky Color"){
            Click.run(ID:"//*[contains(@class,'f-canvas-ai-modal')]//*[contains(@class,'f-colorpicker-trigger')]")
            SetFocus.run(ID:"//INPUT[contains(@id,'editable-input')]")
            SetText.run(ID:"//INPUT[contains(@id,'editable-input')]", Text:params."Sticky Color", "Type of Clear":"Backspace")
            sleep(1000)
        }
        if(params."Action" == "Generate"){Click.run(ID:"//*[@data-test='modal-footer-submit']")}
        else if(params."Action" == "Cancel"){Click.run(ID:"//*[@data-test='modal-footer-cancel']")}
    }
}