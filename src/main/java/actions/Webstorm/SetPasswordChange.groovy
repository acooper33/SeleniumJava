package actions.Webstorm;

import actions.selenium.Click
import actions.selenium.SetText

class SetPasswordChange{
    public void run(def params){
       
        SetText.run(ID:"//*[@id='prEmail']",Text:params."Email")
        SetText.run(ID:"//*[@id='prPass1']",Text:params."Choose Password")
        SetText.run(ID:"//*[@id='prPass2']",Text:params."Confirm Password")
        Click.run(ID:"//*[@id='prForm']/button")
    }
}