package actions.Whiteboards;

import actions.selenium.Click
import org.openqa.selenium.interactions.Actions
import actions.selenium.Browser

class WhiteboardSetAddTable{
    public void run(def params){
        Actions builder = new Actions(Browser.Driver)
        int xCoordinate = params."X coordinate".toInteger()
        int yCoordinate = params."Y coordinate".toInteger()
        if(params."Rows" && params."Columns"){
            Click.run(ID:"//*[@class='f-table-menu-container']//*[@class='f-table-menu-row' and position()='${params."Rows"}']//*[contains(@class,'f-table-menu-cell') and position()='${params."Columns"}']")
        }        
        builder.moveByOffset(xCoordinate, yCoordinate).clickAndHold().pause(1000).release().perform()
    }
}