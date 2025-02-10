package actions.general;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.Exists

class LogintoBrightideaAuth{
    public void run(def params){
        if(params."Email"){
            SetText.run(ID:"//INPUT[@id='f-login-oauth-enter-email']", Text:params."Email")
            Click.run(ID:"//DIV[@class='f-login-oauth-item']/BUTTON")
        }
        if(params."Domain"){
            SetText.run(ID:"//INPUT[@id='f-login-oauth-enter-domain']", Text:params."Domain")
            Click.run(ID:"//DIV[@class='f-login-oauth-item']/BUTTON[contains(@class,'f-login-oauth-action-button')]")
        }
        if(params."Password"){
            SetText.run(ID:"//INPUT[@id='f-login-oauth-enter-password']", Text:params."Password")
            Click.run(ID:"//DIV[@class='f-login-oauth-item']/BUTTON[contains(@class,'f-login-oauth-action-button')]")
        }
        sleep(3000)
        if(Exists.run(ID:"//BUTTON[contains(@class,'f-login-oauth-action-button') and @value='Accept']/span[contains(.,'Allow')]")>0){
            Click.run(ID:"//BUTTON[contains(@class,'f-login-oauth-action-button') and @value='Accept']/span[contains(.,'Allow')]")
        }
        sleep(3000)
    }
}