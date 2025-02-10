package actions.SSOLogin;

import actions.selenium.Click
import actions.selenium.ExplicitWait
import actions.selenium.SetText
import actions.selenium.Browser

class SetSSOLogin{
    public static void run(def params){
        
        if(params."SSO Test"==true){
            Click.run(ID:"//*[@id='saml']")
        }        
        if(params."Dont wait to load" != true){ExplicitWait.run(ID:"//*[@id='username']")}
        if(params."Username"){
            SetText.run(ID:"//*[@id='username']",Text:params."Username")
            Click.run(ID:"//*[@type='submit']")
        }
        sleep(2000)
        if(params."Password"){
            SetText.run(ID:"//*[@id='password']",Text:params."Password")
        	Click.run(ID:"//*[@type='submit']")
        }
        sleep(2000)
    }
}