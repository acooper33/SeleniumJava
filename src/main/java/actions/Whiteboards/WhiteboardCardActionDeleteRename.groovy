package actions.Whiteboards;

import actions.selenium.Click
import actions.selenium.SetFocus
import actions.selenium.SetText
import actions.selenium.MouseOver


class WhiteboardCardActionDeleteRename{
    public void run(def params){
        SetFocus.run(ID:"//DIV[contains(@class,'f-canvas-card')]//DIV[contains(@class,'f-card-title-area')]//*[@class='f-card-title' and .='${params."Whiteboard to Select"}']")
        sleep(1000)
        Click.run(ID:"//DIV[contains(@class,'fractal-dropdown f-canvas-card-options')]//I")
        if(params."Option"){
            Click.run(ID:"//UL[contains(@class,'f-dropdown-options')]/LI//SPAN[contains(.,'${params."Option"}')]")
        }
        if(params."New Title"){
            SetText.run(ID:"//*[@id='f-canvas-rename']", Text:params."New Title", "Type Of Clear":"Cut")
            sleep(3000)
        }
        if(params."Action"){
            if(params."Action"=="Submit"){
                Click.run(ID:"//BUTTON[@id='clickToConfirmOkButton']")
            } else if(params."Action"=="Cancel"){
                Click.run(ID:"//BUTTON[@id='clickToConfirmCancelButton']")
            }
        }
    }
}