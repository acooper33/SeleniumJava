package actions.selenium

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.apache.commons.lang3.StringUtils;

class VerifyText{
    public static void run(def params){
		//Text (string) = Exact uneditable text value in a webelement, value <EMPTY> will validate for null value
        //"Contains Text" (string) = Contains uneditable text value in a webelement
        //"Input Field Text" = Value inside editable text field, value <EMPTY> will validate for null value
        println("In Verify Text")
        println("ID:${params.ID}")
        println("By:${params.By}")
        println("Passed in Text:${params.Text}")
        if(params.Text||params."Contains Text"||params."Input Field Text"){
            WebElement element = Elements.find(params,Browser.Driver)
            def textValue = new String( new StringBuffer(element.getText()))
            textValue = StringUtils.normalizeSpace(textValue)
            println("ElementValue: ${textValue}")
            
            if(params."Contains Text"){
                assert textValue.contains(params."Contains Text"), "Error expected text: ${params."Contains Text"} does not exist in text on the UI: ${textValue}"
            }
            else if(params.Text){
                if(params.Text=="<EMPTY>"){params.Text=""}
                println("textValue: ${textValue.replaceAll("[^a-zA-Z0-9.@\\-]", "")}")
                println("Expected: ${params.Text.replaceAll("[^a-zA-Z0-9.@\\-]", "")}")
                assert textValue.replaceAll("[^a-zA-Z0-9.@\\-]", "").equals(params.Text.replaceAll("[^a-zA-Z0-9.@\\-]", "")), "Error expected text: ${params.Text} does not match text on the UI: ${textValue}"
            }
            //Else it's a text value is in the Input Field (text field and drop down) so it should get attribute by value
            else{
                if(params."Input Field Text"=="<EMPTY>"){params."Input Field Text"=""}
                textValue = new String( new StringBuffer(element.getAttribute("value")))
                assert textValue.trim() == params."Input Field Text".trim(), "Error expected text: ${params."Input Field Text"} does not match text on the UI: ${textValue}"
            }
        }
    }
}