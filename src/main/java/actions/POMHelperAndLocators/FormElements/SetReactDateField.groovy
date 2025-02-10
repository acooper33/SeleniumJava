package actions.POMHelperAndLocators.FormElements;

import actions.selenium.SetText
import screens.ReactFormDifferentFieldLocators
import org.openqa.selenium.By

class SetReactDateField{
    public static run(def params){
        
        ReactFormDifferentFieldLocators.run(params)
        SetText.run("ID Type":"By",By:ReactFormDifferentFieldLocators.dateField,Text:params.Date,"Type of Clear":"Cut")

    }
}