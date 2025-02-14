package actions.selenium

import org.openqa.selenium.JavascriptExecutor
import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement

class MouseOver{

    public static void run(def params){
        WebElement element = Elements.find(params,Browser.Driver)

        JavascriptExecutor jsExec = (JavascriptExecutor) Browser.Driver
        //String javaScript = "var evObj = document.createEvent('MouseEvents');evObj.initEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);arguments[0].dispatchEvent(evObj);"
        String javaScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}"
        jsExec.executeScript(javaScript, element)
        sleep(500)
    }
}