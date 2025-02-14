package actions.selenium


import org.openqa.selenium.JavascriptExecutor

class ExecuteJavascript{

    public static void run(def params){
        def js = (JavascriptExecutor) Browser.Driver
        if(params."Arguments"){js.executeScript(params.Code, params."Arguments")}
        else{js.executeScript(params.Code)}
    }
}

