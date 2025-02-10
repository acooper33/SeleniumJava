package actions.general;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.SelectItem
import actions.selenium.Browser

class CompleteUserRegistration{
    public static void run(def params){
        sleep(5000)
        Browser.Driver.navigate().refresh()
        if(Exists.run(ID:"//*[@id='password']")>0){
            SetText.run(Text:params."Password",ID:"//*[@id='password']")
        	SetText.run(Text:params."Confirm Password",ID:"//*[@id='confirmPassword']")
        }
        SetText.run(Text:params."First Name",ID:"//*[@id='first_name']")
        SetText.run(Text:params."Last Name",ID:"//*[@id='last_name']")
        SetText.run(Text:params."Screen Name",ID:"//*[@id='screen_name']")
        if(params."Security Question"){
            SelectItem.run(ID:"//SELECT[@id='security_question']", 'Visible Text':params."Security Question")
        }
        SetText.run(ID:"//INPUT[@id='security_question_answer']", Text:params."Answer")
        Click.run(ID:"//*[@id='send-button']")
        sleep(4000)
    }
}