package actions.selenium;

import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

class VerifyItemInElement{
    public static void run(def params){
        
        WebElement element = Elements.find(params,Browser.Driver)
        WebElement option = new Select(element).getFirstSelectedOption()
        String selectedText = option.getText();
        println(selectedText)
        assert params.Value == selectedText, "Error: Selected Text not matching"
    }
}