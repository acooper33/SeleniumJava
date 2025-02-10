package actions.general;

import actions.selenium.SetText
import actions.selenium.Click

class SetForgotPassword{
    public void run(def params){

        if(params."Forgot Click" == true){
            Click(ID:"//*[@id='forgot-password-link']")
        }
        SetText.run(Text:params.Email,ID:"//*[@id='emailAddress']")
        Click.run(ID:"//*[@id='send-button']")
    }
}