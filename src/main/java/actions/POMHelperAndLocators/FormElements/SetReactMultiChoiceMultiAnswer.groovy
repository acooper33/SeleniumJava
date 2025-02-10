package actions.POMHelperAndLocators.FormElements;

import actions.selenium.Click
import screens.ReactFormDifferentFieldLocators
import org.openqa.selenium.By

class SetReactMultiChoiceMultiAnswer{
     public static run(def params){
        
        if(params."Field Value"){
             params."Field Value".split(",").eachWithIndex{ value, x ->
                
                def fieldParams = [
                    'Field Name': params."Field Name",
                    'Field Value': value
                ]
                 
                ReactFormDifferentFieldLocators.run(fieldParams)
                if(params."Check or Uncheck checkbox".split(",")[x]=="check") {
                    Click.run("ID Type":"By", By:ReactFormDifferentFieldLocators.multiChoiceCheckboxUnchecked, "Type of Click":"Move to Element")
                } else {
                    Click.run("ID Type":"By", By:ReactFormDifferentFieldLocators.multiChoiceCheckboxChecked, "Type of Click":"Move to Element")
                }
             }
        }
    }
}