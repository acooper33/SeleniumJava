package actions.Whiteboards;

import actions.selenium.Click
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements
import org.openqa.selenium.interactions.Actions
import java.awt.Robot;	
import java.awt.event.KeyEvent;	
import org.openqa.selenium.Point
import java.awt.event.InputEvent;	
import java.awt.event.KeyEvent;

class SetMarkerToolToWhiteboard{
    
    public void run(def params){
        WebElement canvas = Elements.find(["ID":"//canvas[@id='canvas']"],Browser.Driver)
        if(params."Select Position of the Color Option"){Click.run(ID:"//DIV[@class='f-pen-options']/I[${params."Select Position of the Color Option"}]")} // select color
          
        //start at x1,y1, move to x2,y2, stop at x3,y3
        int xCoordinate1 = params."X coordinate1".toInteger()
        int yCoordinate1 = params."Y coordinate1".toInteger()
        int xCoordinate2 = params."X coordinate2".toInteger()
        int yCoordinate2 = params."Y coordinate2".toInteger()
        int xCoordinate3 = params."X coordinate3".toInteger()
        int yCoordinate3 = params."Y coordinate3".toInteger()
        
        Actions builder = new Actions(Browser.Driver)
        //builder.moveByOffset(xCoordinate1, yCoordinate1).clickAndHold().moveByOffset(xCoordinate2, yCoordinate2).moveByOffset(xCoordinate3, yCoordinate3).release().perform(); 
        builder.moveByOffset(xCoordinate1, yCoordinate1).clickAndHold().pause(500).moveByOffset(xCoordinate2, yCoordinate2).pause(500).moveByOffset(xCoordinate3, yCoordinate3).release().perform(); 
        
    }
}