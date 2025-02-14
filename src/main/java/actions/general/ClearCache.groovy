package actions.general;

import actions.selenium.Browser
import actions.selenium.NavigateToURL
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.SearchContext

class ClearCache{
    public void run(def params){
        NavigateToURL.run(URL:'chrome://settings/clearBrowserData')
        WebElement button = findButtonClearData(Browser.Driver)
        button.click()
        sleep(5000)

    }
    public WebElement findButtonClearData(WebDriver Driver) {
        //locating and clicking on the button in shadow DOM
        //cascading down shadow roots
                
        WebElement root1 = Driver.findElement(By.tagName("settings-ui"))
        SearchContext shadowRoot1 = root1.getShadowRoot()
        
        WebElement root2 = shadowRoot1.findElement(By.cssSelector("settings-main#main"))
        SearchContext shadowRoot2 = root2.getShadowRoot()
        
        WebElement root3 = shadowRoot2.findElement(By.cssSelector("settings-basic-page.cr-centered-card-container"))
        SearchContext shadowRoot3 = root3.getShadowRoot()
        
        
        WebElement root4 = shadowRoot3.findElement(By.cssSelector("settings-section[page-title='Privacy and security']"))
        
        WebElement root5 = root4.findElement(By.cssSelector("settings-privacy-page"))
        SearchContext shadowRoot5 = root5.getShadowRoot()
        
        WebElement root6 = shadowRoot5.findElement(By.cssSelector("settings-clear-browsing-data-dialog"))
        SearchContext shadowRoot6 = root6.getShadowRoot()
        
        WebElement root7 = shadowRoot6.findElement(By.cssSelector("cr-dialog"))
        
        //Clear Data button 
        WebElement button = root7.findElement(By.cssSelector("cr-button[id='clearBrowsingDataConfirm']"))
        if (button !=null){println("OK found button")}
        return button
	}
}