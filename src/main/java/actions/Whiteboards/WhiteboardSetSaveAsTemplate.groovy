package actions.Whiteboards;

import actions.selenium.SetText
import actions.selenium.Click
import actions.WebstormHomepage.SetActionOnChangeBackgroundModal


class WhiteboardSetSaveAsTemplate{
    public void run(def params){
        if(params."Template Name"){
            SetText.run(ID:"//INPUT[@id='f-canvas-template-name']", Text:params."Template Name", "Type of Clear":"Cut")
        }
        if(params."Save a copy of the whiteboard as a template"==true){
            println("Save a copy of the whiteboard as a template==true")
            Click.run(ID:"//DIV[not(contains(@class,'f-checkbox-checked'))]//INPUT[@id='share-dialog-object-select']/..")
        }
        if(params."Save a copy of the whiteboard as a template"==false){
            println("Save a copy of the whiteboard as a template==false")
            Click.run(ID:"//DIV[contains(@class,'f-checkbox-checked')]//INPUT[@id='share-dialog-object-select']/..")
        }
        if(params."Action"=="Save Template"){SetActionOnChangeBackgroundModal.setAction(Action:"Add")}
        else{SetActionOnChangeBackgroundModal.setAction(Action:"Cancel")}
    }
}