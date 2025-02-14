package actions.selenium;


import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

class SelectItem{

    public static void run(def params){
        if(params."Visible Text"||params."Value"||params.Index){
            WebElement element = Elements.find(params,Browser.Driver)
            
            if(params."Visible Text"){
                println("In SelectItem, will select ${params."Visible Text"}")
                new Select(element).selectByVisibleText(params."Visible Text")
                /*//If failed to select an item (Firefox caused this issue), then try to select by clicks
                def option = new Select(element).getFirstSelectedOption()
                String selectedLabel = option.getText()
                if(selectedLabel!=params."Visible Text"){
                    Click.run(params)
                    Click.run(ID:params.ID+"//*[text()='${params."Visible Text"}']")
                }*/
            }
            else if(params."Value"){
                new Select(element).selectByValue(params."Value")
            }
            else if (params.Index){
                new Select(element).selectByIndex(params.Index.toInteger())
            }
        }
    }
}