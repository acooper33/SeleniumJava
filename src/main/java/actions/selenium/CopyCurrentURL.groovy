package actions.selenium;

import actions.selenium.Browser

class CopyCurrentURL{
    public String run(def params){
        def currentURL
        currentURL = Browser.Driver.getCurrentUrl()
        println("URL: "+ currentURL)
        return currentURL
    }
}