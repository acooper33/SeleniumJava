package actions.general;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.Exists

class CompleteUserRegistrationFromInitiativeLoginPage{
    public void run(def params){
        if(Exists.run(ID:"//INPUT[@id='b_register_screen_name']")==1){
            SetText.run(Text:params."Screen Name",ID:"//*[@id='b_register_screen_name']")
        	SetText.run(Text:params."Choose Password",ID:"//*[@id='b_register_password1']")
        	SetText.run(Text:params."Confirm Password",ID:"//*[@id='b_register_password2']")
        }else{
            SetText.run(Text:params."Screen Name",ID:"//*[@name='SCREEN_NAME']")
        	SetText.run(Text:params."Choose Password",ID:"//*[@id='Password2']")
        	SetText.run(Text:params."Confirm Password",ID:"//*[@id='Password3']")
        }
        Click.run(ID:"//*[@id='SubmitButton2']")
        sleep(4000)
        
    }
}