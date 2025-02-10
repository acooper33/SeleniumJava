package actions.selenium

import actions.selenium.utils.Elements
import actions.selenium.Browser
import actions.selenium.Click
import org.openqa.selenium.WebElement

class SetCheckBox{  
    public static void run(def params){
        if(params.Check!=null){
            WebElement element = Elements.find(params,Browser.Driver)
            if(params.Check == true){
                println("We need to check the checkbox")
                if(element.selected == false){ // || element.getAttribute("value") ==false){
                    //element.sendKeys(org.openqa.selenium.Keys.SPACE)
                    println("Selected attribute is false")
                    Click.run(params)
                }
            }
            else{
                if(element.selected == true){
                    println("Selected attribute is true or n/a")
                    //element.sendKeys(org.openqa.selenium.Keys.SPACE)
                    Click.run(params)
                }
            }
        }
    }
}