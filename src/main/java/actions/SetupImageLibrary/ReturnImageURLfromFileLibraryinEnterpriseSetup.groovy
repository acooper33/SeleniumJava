package actions.SetupImageLibrary;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class ReturnImageURLfromFileLibraryinEnterpriseSetup{
    public static def run(def params){
        
        WebElement element = Elements.find(ID:"//*[@id='image_list']//A[text()='${params."File Name"}']/parent::DIV/parent::TD/parent::TR//INPUT[@class='input_box']",Browser.Driver)
        def url = element.getAttribute("value")
        println(url)
        return url
    }
}