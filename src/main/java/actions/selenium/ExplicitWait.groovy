package actions.selenium


import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions

class ExplicitWait{
    public static void run(def params){                                                         
        (new WebDriverWait(Browser.Driver,100)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(params.ID)))

    }
}