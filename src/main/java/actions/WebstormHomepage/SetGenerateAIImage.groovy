package actions.WebstormHomepage;

import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements
import org.openqa.selenium.JavascriptExecutor
import actions.selenium.*
    
class SetGenerateAIImage{
    public void run(def params){
        
        WebElement image
        SetText.run(ID:"//*[@id='f-dalle-input']", Text:params."Text to Search","Type of Clear":"Cut")
        if(params."Action to Generate Images"){
            if(params."Action to Generate Images"=="Click on Enter Key"){
                Actions action = new Actions(Browser.Driver)
                action.sendKeys(Keys.ENTER).build().perform()  
            } else {
              Click.run(ID:"//*[contains(@class,'f-dalle-button')]")  
            }
            while(Exists.run(ID:"//*[contains(@class,'f-dalle-item f-animate-pulse')]")>=1){
            sleep(5000)
            }
        }
        if(params."Image Dropdown Menu"){
            SetFocus.run(ID:"//*[contains(@class,'f-dalle-item')][${params."AI Image Number to Open Dropdown Menu"}]")
            Click.run(ID:"//*[@class='f-dalle']//*[contains(@class,'fa-ellipsis-h')]")
            Click.run(ID:"//*[contains(@class,'f-dropdown-options') and contains(@style,'block')]//*[text()='${params."Image Dropdown Menu"}']")
            if(params."Image Dropdown Menu"=="Generate Variation"){
                while(Exists.run(ID:"//*[contains(@class,'f-dalle-item f-animate-pulse')]")>=1){
            	sleep(7000)    
                }
            }
        }         
        if(params."AI Image Number to Click"){
           image = Elements.find(ID:"//*[contains(@class,'f-dalle-item')][${params."AI Image Number to Click"}]",Browser.Driver)
        		JavascriptExecutor executor = (JavascriptExecutor) Browser.Driver
        		executor.executeScript("arguments[0].scrollIntoView();", image)
        		sleep(3000)
        		image.click() 
        }
        SetActionOnChangeBackgroundModal.setAction(Action:params."Action")
        sleep(3000)
    }
}