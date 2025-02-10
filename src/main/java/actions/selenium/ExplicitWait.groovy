package actions.selenium;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions

class ExplicitWait{
    public static void run(def params){                                                         
        (new WebDriverWait(Browser.Driver,100)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(params.ID)))

    }
}