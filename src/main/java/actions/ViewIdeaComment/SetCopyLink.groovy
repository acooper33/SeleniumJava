package actions.ViewIdeaComment;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.Keys

class SetCopyLink{
    public void run(def params){

        Browser.Driver.get(new Actions(Browser.Driver).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "v")).build().perform())
    }
}