package actions.Utils;

import actions.selenium.ExecuteJavascript
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor

class ScrollingThroughElementOnPage{
    public void run(def params){
        WebElement list = Elements.find([ID:"//UL[@class='recent-list']", "ID Type":params."From ID Type"],Browser.Driver)
        ExecuteJavascript.run(Code:"arguments[0].scrollTo(0, arguments[0].scrollHeight)", Arguments:list)
        
        /*def js = (JavascriptExecutor) Browser.Driver
        js.executeScript("arguments[0].scrollTo(0, arguments[0].scrollHeight)", list);*/
        
        
    }
}