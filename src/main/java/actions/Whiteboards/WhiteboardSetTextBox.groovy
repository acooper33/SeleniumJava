package actions.Whiteboards;

import org.openqa.selenium.interactions.Actions
import actions.selenium.Browser

class WhiteboardSetTextBox{
    public void run(def params){
        Actions builder = new Actions(Browser.Driver)
        def x = params."X coordinate".toInteger()
        def y = params."Y coordinate".toInteger()
        //builder.moveByOffset(x, y).click().pause(1000).moveByOffset(10,0).perform()
        builder.moveByOffset(x, y).clickAndHold().pause(1000).release().perform()
                
    }
}