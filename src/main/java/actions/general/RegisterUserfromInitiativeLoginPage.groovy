package actions.general;

import actions.selenium.SetText
import actions.selenium.Click

class RegisterUserfromInitiativeLoginPage{
    public void run(def params){
        Click.run(ID:"//*[@id='lr_inner']//A[text()='Register']")
        sleep(3000)
        SetText.run(Text:params."Email Address",ID:"//*[@id='register_email']")
        Click.run(ID:"//*[@id='private_register_button']")       
    }
}