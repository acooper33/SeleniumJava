package actions.Whiteboards;

import org.openqa.selenium.interactions.Actions
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements

class ClickOnWhiteboardCanvas{
    public void run(def params){
        Actions builder = new Actions(Browser.Driver)
        def x = params."X coordinate".toInteger()
        def y = params."Y coordinate".toInteger()
        println("Move by offset x:${x} y:${y}")
        sleep(2000)
        if(params."Single Double or Right Click" == 'Single Click'){
            builder.moveByOffset(x, y).click().perform()
        }else if (params."Single Double or Right Click" == 'Double Click'){
            builder.moveByOffset(x, y).doubleClick().moveByOffset(0,0).doubleClick().perform();
            //builder.moveByOffset(x, y).doubleClick().perform();
        }else if(params."Single Double or Right Click" == 'Right Click'){
            builder.moveByOffset(x, y).click().moveByOffset(0,0).contextClick().perform()
        }
        sleep(1000)
    }
}