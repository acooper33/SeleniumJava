package actions.selenium;
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements
import org.openqa.selenium.JavascriptExecutor
/*
Inputs
ID: Xpath to element
ID Type:
Text: Text to input
Attribute: innerHTML or value
*/

class SetTextWithJavascript{
    public void run(def params){
        println("Running SetTextWithJavascript")
        
        //Javascript Code
        def code = ""
        if(params."Attribute"=="innerHTML"){
            code = '''
            var elm = arguments[0];
			elm.innerHTML = arguments[1];
            elm.dispatchEvent(new Event('change'));'''
        }else{
            code = '''
            var elm = arguments[0];
			elm.value = arguments[1];
            elm.dispatchEvent(new Event('change'));'''
        }


        // Find element
        WebElement element = Elements.find(params,Browser.Driver)
        
        // Execute Javascript
        def js = (JavascriptExecutor) Browser.Driver
        println("Executing SetTextWithJavascript()")
        println("Code: ${code}")
        println("Attribute: ${params."Attribute"}")
        println("Text: ${params."Text"}")
        js.executeScript(code, element, params."Text")
        println("Execution of SetTextWithJavascript() is complete")

    }
}