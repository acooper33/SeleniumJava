package actions.Whiteboards


import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class AddStickyNoteToWhiteboard{
    public void run(def params){
        Actions builder = new Actions(Browser.Driver)
        if(params."Add via Double Click or Drag and Drop" == "Drag and Drop"){ //not working
            if(params."Select Placement of the Color Option"){
                WebElement tool = Elements.find(ID:"//DIV[@class='f-canvas-left-toolbar']//BUTTON[@data-tip='Sticky Note']",Browser.Driver)
            	WebElement element = Elements.find(["ID":"//DIV[@class='f-note-options']/I[${params."Select Placement of the Color Option"}]"],Browser.Driver)
            	WebElement target = Elements.find(["ID":"//*[@id='canvas']"],Browser.Driver)
            	sleep(2000)
            	int xCoordinate = params."X coordinate".toInteger()
            	int yCoordinate = params."Y coordinate".toInteger()
            	builder.clickAndHold(element).moveToElement(target).perform()
            	builder.moveByOffset(target.getLocation().getX()+xCoordinate, target.getLocation().getY()+yCoordinate).release().pause(2000).perform()
            }
        }else if (params."Add via Double Click or Drag and Drop" == "Double Click"){
            int xCoordinate = params."X coordinate".toInteger()
            int yCoordinate = params."Y coordinate".toInteger()
            builder.moveByOffset(xCoordinate, yCoordinate).click().moveByOffset(0,0).doubleClick().perform();
        }else if (params."Add via Double Click or Drag and Drop" == "Single Click"){
            if(params."Select Placement of the Color Option"){
            	WebElement color = Elements.find(["ID":"//DIV[@class='f-note-options']/I[${params."Select Placement of the Color Option"}]"],Browser.Driver)
           		color.click()
            }
            int xCoordinate = params."X coordinate".toInteger()
            int yCoordinate = params."Y coordinate".toInteger()
            //builder.moveByOffset(xCoordinate, yCoordinate).click().moveByOffset(0,0).click().perform();
            builder.moveByOffset(xCoordinate, yCoordinate).clickAndHold().pause(1000).release().perform()
        }
        sleep(1000)
    }
}