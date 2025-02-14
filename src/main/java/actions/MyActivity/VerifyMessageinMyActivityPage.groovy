package actions.MyActivity;

import actions.selenium.VerifyText

class VerifyMessageinMyActivityPage{
    public void run(def params){

        if(params."Message body") {VerifyText.run(ID:"//*[starts-with(@id,'my_private_messages') and contains(@style,'block')]//*[@class='profile_my_messages_body' and starts-with(text(),'${params."Message body"}')]" ,"Text":params."Message body")}
        if(params."Date") {VerifyText.run(ID:"//*[starts-with(@id,'my_private_messages') and contains(@style,'block')]//*[@class='profile_my_messages_time' and text()='${params."Date"}']" ,"Text":params."Date")}
        if(params."Subject") {VerifyText.run(ID:"//*[starts-with(@id,'my_private_messages') and contains(@style,'block')]//*[starts-with(@class,'my_messages')]/*[text()='${params."Subject"}']" ,"Text":params."Subject")}
        if(params."Recipient or Sender") {VerifyText.run(ID:"//*[starts-with(@id,'my_private_messages') and contains(@style,'block')]//*[starts-with(@class,'my_messages_user')]/*[text()='${params."Recipient or Sender"}']" ,"Text":params."Recipient or Sender")}
    }
}