package screens.SiteSetup;

import org.openqa.selenium.By

class SchedulerLocators{
    
    static By disableScheduler
    static By searchField
    static By closeIconOnSearchField
        
    public static void run(def params) {
        disableScheduler = By.xpath("//*[contains(@class,'f-disable-container')]/A")
        searchField = By.xpath("//*[contains(@class,'f-group-manager-search')]//INPUT")
        closeIconOnSearchField = By.xpath("//*[contains(@class,'f-group-manager-search')]//I")
    }
}