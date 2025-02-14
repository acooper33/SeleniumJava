package actions.selenium

import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class RightClick{

    public static run(def params){
        WebElement element = Elements.find(params,Browser.Driver)

        Actions action = new Actions(Browser.Driver)

        action.contextClick(element).perform()

    }
}