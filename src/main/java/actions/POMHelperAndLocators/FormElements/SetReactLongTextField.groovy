package actions.POMHelperAndLocators.FormElements;

import actions.selenium.SetText
import screens.ReactFormDifferentFieldLocators
import org.openqa.selenium.By

class SetReactLongTextField{
     public static run(def params){
        
        ReactFormDifferentFieldLocators.run(params)
        SetText.run(Text:params."Field Value","ID Type":"By",By:ReactFormDifferentFieldLocators.longTextField) 
        
    }
}