package actions.Enterprise;

import actions.selenium.Click
import actions.selenium.SetText

class SetEnterprisePasswordChange{
    public void run(def params){
        SetText.run(ID:"//*[@id='password']",Text:params."New Password")
        SetText.run(ID:"//*[@id='confirmPassword']",Text:params."Confirm Password")
        SetText.run(ID:"//*[@id='securityQuestionAnswer']",Text:params."Security Question Answer")
        Click.run(ID:"//*[@id='reset-button']")
    }
}