package actions.POMHelperAndLocators.FormElements;

import actions.selenium.Click
import screens.ReactFormDifferentFieldLocators
import org.openqa.selenium.By

class SetReactMultiChoiceOneAnswer{
    public static run(def params){
       
        ReactFormDifferentFieldLocators.run(params)
        Click.run("ID Type":"By",By: ReactFormDifferentFieldLocators.radioButton) 
        
    }
}