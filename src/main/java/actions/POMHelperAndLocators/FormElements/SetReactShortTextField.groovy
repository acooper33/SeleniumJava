package actions.POMHelperAndLocators.FormElements;

import actions.selenium.SetText
import screens.ReactFormDifferentFieldLocators

class SetReactShortTextField{
    public static run(def params){
        
        ReactFormDifferentFieldLocators.run(params)
        SetText.run(Text: params."Field Value", ID: ReactFormDifferentFieldLocators.shortTextField)
        
    }
}