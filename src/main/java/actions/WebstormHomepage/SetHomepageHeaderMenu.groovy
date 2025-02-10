package actions.WebstormHomepage;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SetFocus
import actions.selenium.Browser
import actions.selenium.utils.Elements
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.WebElement

class SetHomepageHeaderMenu{
    public void run(def params){
        
        if(params."Title"){
            SetFocus.run(ID:"//*[@id='f-homepage-redactor-name']/../DIV[2]")
            SetText.run(ID:"//*[@id='f-homepage-redactor-name']/../DIV[2]",Text:params."Title","Type of Clear":"Cut")
        }
        
        if(params."Description"){
            SetFocus.run(ID:"//*[@id='f-homepage-redactor-description']/../DIV[2]")
            SetText.run(ID:"//*[@id='f-homepage-redactor-description']/../DIV[2]",Text:params."Description","Type of Clear":"Cut")
        }
 
        if(params."Click on Edit Dropdown"==true){
            Click.run(ID:"//*[@data-test='f-test-comment-edit-dropdown']")
            sleep(2000)
        }
        if(params."Submit"==true){Click.run(ID:"//*[contains(@class,'f-dropdown-options')]//LI[1]/DIV/DIV[not(contains(@class,'f-checkbox-checked'))]//*[@class='f-checkbox-inner']")}
        if(params."Submit"==false){Click.run(ID:"//*[contains(@class,'f-dropdown-options')]//LI[1]/DIV/DIV[contains(@class,'f-checkbox-checked')]//*[@class='f-checkbox-inner']")}      
        if(params."Browse"==true){Click.run(ID:"//*[contains(@class,'f-dropdown-options')]//LI[2]/DIV/DIV[not(contains(@class,'f-checkbox-checked'))]//*[@class='f-checkbox-inner']")}
        if(params."Browse"==false){Click.run(ID:"//*[contains(@class,'f-dropdown-options')]//LI[2]/DIV/DIV[contains(@class,'f-checkbox-checked')]//*[@class='f-checkbox-inner']")}
        
        if(params."Adjust for Readability"==true){
            Click.run(ID:"//*[@id='f-homepage-hero-buttons-readability']")
            WebElement element = Elements.find(ID:"//*[@class='rc-slider-handle']",Browser.Driver)
            new Actions(Browser.Driver).moveToElement(element, 75, 0).click().build().perform()
        }
        if(params."Action"){
            Click.run(ID:"//*[contains(@class,'fractal-button')]/*[text()='${params."Action"}']")
        }
    }
}