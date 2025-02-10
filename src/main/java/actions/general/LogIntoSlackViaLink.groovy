package actions.general;

import actions.selenium.SetText
import actions.selenium.Click
import java.awt.Robot;	
import java.awt.event.KeyEvent;	
import actions.selenium.SendKeyboardAction
import actions.selenium.Exists

class LogIntoSlackViaLink{
    public void run(def params){
        if(params."Email"){SetText.run(ID:"//INPUT[@id='email']", Text:params."Email")}
        if(params."Password"){SetText.run(ID:"//INPUT[@id='password']", Text:params."Password")}
        Click.run(ID:"//BUTTON[@id='signin_btn']")
        sleep(3000)
        SendKeyboardAction.run("Button":"Keys.TAB")
        SendKeyboardAction.run("Button":"ENTER")
        sleep(2000)
    }
}