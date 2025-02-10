package actions.selenium;

import actions.selenium.ExecuteJavascript
import actions.selenium.Browser;
import actions.selenium.SwitchWindow

class OpenURLInNewTab{
    public void run(def params){
        ExecuteJavascript.run(Code:"window.open()")
        SwitchWindow.run("Tab (start from 0)":params."Tab Order Number (start from 0)")
        if(params.URL){
            Browser.Driver.get(params.URL)
        }
    }
}