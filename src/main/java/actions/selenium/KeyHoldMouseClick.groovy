package actions.selenium;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.Keys

class KeyHoldMouseClick{
    public void run(def params){
        Actions builder = new Actions(Browser.Driver);
        WebElement clickElement = Elements.find(ID:params."xPath of the element to click",Browser.Driver)
        if(params."What Key to Press & Hold".toLowerCase().contains("control")){
        	builder.keyDown(Keys.LEFT_CONTROL)
            .click(clickElement)
            .keyUp(Keys.LEFT_CONTROL)
            .build()
            .perform();
        }
    }
}