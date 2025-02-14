package actions.SetupUsers;

import actions.selenium.SetText
import actions.selenium.Click

class ChangePasswordExistingUser{
    public void run(def params){
        if(params."New Password"){
            Click.run(ID:"//A[@id='ent_change_password']")
            sleep(1000)
            SetText.run(ID:"//*[@id='gen_message_popup']//INPUT[@id='user_password']", Text:params."New Password")
            SetText.run(ID:"//*[@id='gen_message_popup']//INPUT[@id='user_password_1']", Text:params."New Password")
            Click.run(ID:"//*[@id='gen_message_popup']//BUTTON[text()='Submit Change']")
        }
        
    }
}