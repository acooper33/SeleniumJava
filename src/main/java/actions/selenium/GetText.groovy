package actions.selenium

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class GetText{

    public static String run(def params){
        //ID or ELEMENT = If ID is specified then use that, otherwise use Element
        WebElement element
        if(params.ID){
            element  = Elements.find(params,Browser.Driver)
        }
        else{
            element = params.Element
        }

        return element.getText()
    }
}