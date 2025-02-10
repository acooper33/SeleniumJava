package actions.Utils;

import actions.selenium.ExecuteJavascript
import org.openqa.selenium.Keys
import actions.selenium.Browser
import org.openqa.selenium.By
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor


class ScrollPagetoToporBottom{
    public void run(def params){
        if(params."Top or Bottom"=="Top"){
            //ExecuteJavascript.run(Code:"window.scrollTo(100, 0);")
            Browser.Driver.findElement(By.tagName("body")).sendKeys(Keys.UP)
        } else {
            sleep(2000)
            Browser.Driver.findElement(By.tagName("body")).sendKeys(Keys.END)
        }
        
    }
}