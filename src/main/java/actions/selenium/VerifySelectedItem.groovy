package actions.selenium

import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

class VerifySelectedItem{
    public static void run(def params){
        if(params."Item Label" || params."Item Value"){
            WebElement element = Elements.find(params,Browser.Driver)
            def option = new Select(element).getFirstSelectedOption()
            String selectedLabel = option.getText()
            String selectedValue = option.getAttribute("value")
            
            if(params."Item Label"){
                assert selectedLabel == params."Item Label", "Error: Selected option ${selectedLabel} does not match expected option of: ${params."Item Label"}"
            }
            
            if(params."Item Value"){
                assert selectedValue == params."Item Value", "Error: Selected option ${selectedValue} does not match expected option of: ${params."Item Value"}"
            }
        }
    }
}