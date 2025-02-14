package actions.WebstormHomepage


import org.openqa.selenium.JavascriptExecutor
import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement
import actions.selenium.*

class SetPresetBackgroundImageintheHeader{
    public void run(def params){
       
        WebElement image
        if(params."Preset Image Name"){
            image = Elements.find(ID:"//*[@class='f-preset-item' and contains(@style,'${params."Preset Image Name"}-header-thumbnail.png')]",Browser.Driver)
        } else if(params."Unpslash Image Number"){
           //SetText.run(ID:"//*[@id='f-unsplash-input']",Text:params."Unsplash Image Text","Type of Clear":"Cut")
           SetText.run(ID:"//*[@id='f-unsplash-input']",Text:params."Unsplash Image Text")
           sleep(5000)
           image = Elements.find(ID:"//*[@class='f-unsplash-item'][${params."Unpslash Image Number"}]",Browser.Driver)
        }
        
        JavascriptExecutor executor = (JavascriptExecutor) Browser.Driver
        executor.executeScript("arguments[0].scrollIntoView();", image)
        
        image.click()
        SetActionOnChangeBackgroundModal.setAction(Action:params."Action")
    }
}