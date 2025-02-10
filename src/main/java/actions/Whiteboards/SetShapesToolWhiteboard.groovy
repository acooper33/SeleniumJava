package actions.Whiteboards;

import actions.selenium.Click
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.Point
import actions.selenium.DragAndDrop

import java.awt.Robot;	
import java.awt.event.KeyEvent;	
import org.openqa.selenium.Point
import java.awt.event.InputEvent;	
import java.awt.event.KeyEvent;


class SetShapesToolWhiteboard{
    public void run(def params){
        
        Actions builder = new Actions(Browser.Driver)
        if (params."Add via Single Click or Drag and Drop" == "Single Click"){
            if(params."Select Shape (if other than square)"){
                println("Selecting Shape ${params."Select Shape (if other than square)"}")
                Click.run(ID:"//DIV[@class='f-shape-options']/I[contains(@class,'${params."Select Shape (if other than square)"}')]")
                sleep(500)
            }
            if(params."X coordinate" !=null && params."Y coordinate" !=null){
                sleep(2000)
                int xCoordinate = params."X coordinate".toInteger()
        		int yCoordinate = params."Y coordinate".toInteger()
                println("Moving to X:${params."X coordinate"} and Y:${params."Y coordinate"}")
                //builder.moveByOffset(xCoordinate, yCoordinate).clickAndHold().pause(1000).release().perform()
                builder.moveByOffset(xCoordinate, yCoordinate).click().moveByOffset(0,0).click().perform();
                sleep(1000)
            }
        }else if(params."Add via Single Click or Drag and Drop" == "Drag and Drop"){  //not working
            
        	Robot robot = new Robot();
            int xCoordinate = params."X coordinate".toInteger()
        	int yCoordinate = params."Y coordinate".toInteger()
            
            WebElement tool = Elements.find(["ID":"//DIV[@class='f-canvas-left-toolbar']//BUTTON[contains(@data-tip, 'Shapes')]"],Browser.Driver)
            WebElement shape = Elements.find(["ID":"//DIV[@class='f-shape-options']/I[contains(@class,'${params."Select Shape (if other than square)"}')]"],Browser.Driver)
            WebElement canvas = Elements.find(["ID":"//*[@id='canvas']"],Browser.Driver)
            System.out.println("The canvas width is : "+canvas.getAttribute("width"))
            
            Point pointShape = shape.getLocation();
        	int xcordShape = pointShape.getX();
			int ycordShape = pointShape.getY();
            
            Point pointTool = tool.getLocation();
            int xcordTool = pointTool.getX();
            int ycordTool = pointTool.getY();
            
        	//builder.moveToElement(shape).clickAndHold().pause(2000).moveByOffset(50, 0).pause(2000).moveByOffset(200, 0).release().build().perform();
            //builder.clickAndHold(shape).pause(2000).moveByOffset(200, 0).perform().release(shape).perform();
            
            //DragAndDrop.run("From ID":"//DIV[@class='f-shape-options']/I[contains(@class,'${params."Select Shape (for Drag and Drop)"}')]", "To ID":"//*[@class='f-canvas-left-toolbar']")
            
            //builder.clickAndHold(shape).pause(2000).perform();
                                    
            robot.mouseMove(xcordTool, ycordTool);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseMove(100, 100);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
        sleep(1000)
    }
}