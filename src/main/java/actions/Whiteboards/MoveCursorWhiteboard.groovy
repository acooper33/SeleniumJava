package actions.Whiteboards


import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements
import org.openqa.selenium.interactions.Actions

class MoveCursorWhiteboard{
    public void run(def params){
    	WebElement canvas = Elements.find(["ID":"//canvas[@id='canvas']"],Browser.Driver)
        int xCoordinate1 = params."X coordinate1".toInteger()
        int yCoordinate1 = params."Y coordinate1".toInteger()
        int xCoordinate2 = params."X coordinate2".toInteger()
        int yCoordinate2 = params."Y coordinate2".toInteger()
        
        Actions builder = new Actions(Browser.Driver)
        builder.moveByOffset(xCoordinate1, yCoordinate1).click().moveByOffset(xCoordinate2, yCoordinate2).contextClick().perform(); 
       
    }
}