package actions.Whiteboards;

import actions.selenium.Click
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements
import org.openqa.selenium.Point
import org.openqa.selenium.interactions.Actions

class AddStampToWhiteboard{
    public void run(def params){
        
        //select stamp tool
        Click.run(ID:"//DIV[@class='f-canvas-left-toolbar']//BUTTON[@data-tip='Stamps']")
        //find the image to insert
        //Click.run(ID:"//DIV[@class='f-stamp-options']/DIV[${params."Select Position of the Stamp"}]", "Type of Click":"Javascript")
        WebElement stampImg = Elements.find(["ID":"//DIV[@class='f-stamp-options']/DIV[${params."Select Position of the Stamp"}]"],Browser.Driver)
        WebElement canvas = Elements.find(["ID":"//canvas[@id='canvas']"],Browser.Driver)
        Point stampImgLocation = stampImg.getLocation();
        Point canvasLocation = canvas.getLocation();
        println("Location: ${stampImgLocation}")
        println("Location canvaas: ${canvasLocation}")
        
        
        new Actions(Browser.Driver)
        	.clickAndHold(stampImg)
        	.pause(2000)
        	.moveToElement(canvas, 600, -500)
            .pause(2000)
        	.release()
        	.clickAndHold(stampImg)
        	.pause(2000)
        	.moveToElement(canvas, 600, -500)
            .pause(2000)
        	.release()
        	.build()
        	.perform(); 
        
    }
        
        
        
}