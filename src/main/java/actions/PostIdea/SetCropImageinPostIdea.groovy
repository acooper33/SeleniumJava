package actions.PostIdea;
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import actions.selenium.Click
import actions.selenium.utils.Elements

class SetCropImageinPostIdea{
    public void run(def params){
        
        WebElement element = Elements.find(["ID":"//*[@class='ReactCrop__crop-selection']"],Browser.Driver)
        Actions crop = new Actions(Browser.Driver)
        crop.clickAndHold(element).moveByOffset(100, 200).release().build().perform()
        if(params."Action"){
            if(params."Action"=="Crop"){
                Click.run(ID:"//*[@id='f-modal-submit']")
            } else if(params."Action"=="Cancel"){
                Click.run(ID:"//*[@data-test='modal-footer-cancel']")
            } else {
                Click.run(ID:"//*[@data-for='modal-close']")
            }
        }
    }
}