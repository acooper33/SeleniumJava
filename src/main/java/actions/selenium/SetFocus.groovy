package actions.selenium

import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class SetFocus{

    public static void run(def params){
        WebElement element = Elements.find(params,Browser.Driver)
        if(element.getTagName() == "input"){
            element.sendKeys("");
        } 
        else{
            println("not input")
            new Actions(Browser.Driver).moveToElement(element).perform();
        }
        sleep(500)
    }
}