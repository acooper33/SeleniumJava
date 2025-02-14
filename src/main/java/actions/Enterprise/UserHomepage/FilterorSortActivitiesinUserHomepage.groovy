package actions.Enterprise.UserHomepage;

import actions.selenium.Click
import actions.selenium.Browser
import actions.selenium.SelectItem
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.By

class FilterorSortActivitiesinUserHomepage{
    public void run(def params){
        if(params."Filter by"){
            Click.run(ID:"//button[.='${params."Filter by"}']")
        }
        if(params."Sort by"){
            Click.run(ID:"//*[@class='fractal-widget-activities']//div[contains(@class,'f-dropdown-btn')]")
            //Click.run(ID:"//*[@class='fractal-dropdown']/div[contains(@class,'f-dropdown-btn')]")
            //WebDriverWait wait = new WebDriverWait(Browser.Driver,3)
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UL[@class='f-dropdown-options']")));
			sleep(3000)
            Click.run(ID:"//UL[contains(@class,'f-dropdown-options')]/LI[span='${params."Sort by"}']")
        }
        sleep(500)
    }
}