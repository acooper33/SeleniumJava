package actions.Messages;

import actions.selenium.SetText
import actions.selenium.Click

class SetActionsonViewPrivateMessage{
    public void run(def params){

        if(params."Reply Message"){
            SetText.run(ID:"//*[@id='message']",Text:params."Reply Message")
            Click.run(ID:"//*[@id='reply_form']//button[@type='submit']")
        }
        if(params."Back"){
            Click.run(ID:"//*[@id='article']//a[text()='back']")
        }
        if(params."Delete"){
            Click.run(ID:"//*[@id='article']//a[text()='delete']")
        }
        if(params."Mark as Unread"){
            Click.run(ID:"//*[@id='article']//a[text()='mark as unread']")
        }
    }
}