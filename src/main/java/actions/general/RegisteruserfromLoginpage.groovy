package actions.general;

import actions.selenium.SetText
import actions.selenium.Click

class RegisteruserfromLoginpage{
    public static void run(def params){
        Click.run(ID:"//*[@id='register-link']")
        sleep(3000)
        SetText.run(Text:params."Email Address",ID:"//*[@id='emailAddress']")
        SetText.run(Text:params."First Name",ID:"//*[@id='firstName']")
        SetText.run(Text:params."Last Name",ID:"//*[@id='lastName']")
        Click.run(ID:"//*[@id='register-button']")
    }
}