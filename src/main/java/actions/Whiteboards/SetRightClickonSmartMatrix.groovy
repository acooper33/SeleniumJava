package actions.Whiteboards;

import actions.selenium.*
import org.openqa.selenium.interactions.Actions

class SetRightClickonSmartMatrix{
    public static void run(def params){
        
        if(params."X Coordinate" && params."Y Coordinate") {
            int xCoordinate = params."X Coordinate".toInteger()
            int yCoordinate = params."Y Coordinate".toInteger()
            Actions builder = new Actions(Browser.Driver)
        	builder.moveByOffset(xCoordinate, yCoordinate).contextClick().build().perform() 
        }       
        if(params."Menu Option") Click.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[contains(text(),'${params."Menu Option"}')]")
        sleep(2000)
        if(params."Smart Matrix Name"){
            println("Smart Matrix name: ${params."Smart Matrix Name"}")
            //Click.run(ID:"//*[@id='f-matrix-name']", Text: params."Smart Matrix Name")
            SetText.run(ID:"//*[@id='f-matrix-name' and @placeholder='Enter matrix name']", Text: params."Smart Matrix Name")
        }
        
        if(params."X Axis Labels"){
            SetText.run(ID:"//*[@id='f-canvas-select-xaxis']", Text: params."X Axis Labels", "Type of Clear":"Backspace")
            sleep(2000)
            Click.run(ID:"//*[@id='f-combobox-list' and contains(@style,'display: flex')]//*[text()='${params."X Axis Labels"}']", "Type of Click":"Move to Element")
        }
        if(params."Y Axis Labels"){
            SetText.run(ID:"//*[@id='f-canvas-select-yaxis']", Text: params."Y Axis Labels", "Type of Clear":"Backspace")
            sleep(2000)
            Click.run(ID:"//*[@id='f-combobox-list' and contains(@style,'display: flex')]//*[text()='${params."Y Axis Labels"}']", "Type of Click":"Move to Element")
        }
        if(params."Connect to Activity"){
            SetText.run(ID:"//*[@id='f-canvas-select-initiative']", Text: params."Connect to Activity", "Type of Clear":"Backspace")
            sleep(2000)
            Click.run(ID:"//*[@id='f-combobox-list' and contains(@style,'display: flex')]//*[text()='${params."Connect to Activity"}']", "Type of Click":"Move to Element")
        }
        if(params."Matrix Settings Action"){
            if(params."Matrix Settings Action"=="Save") {
                Click.run(ID:"//*[@data-test='modal-footer-submit']")
        } else {
                Click.run(ID:"//*[@data-test='modal-footer-cancel']")
            }
        }
    }
}