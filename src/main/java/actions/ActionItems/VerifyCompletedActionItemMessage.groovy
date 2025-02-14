package actions.ActionItems;

import actions.selenium.Click
import actions.selenium.Exists

class VerifyCompletedActionItemMessage{
    public void run(def params){
        
       if(params."Should the Message be Displayed" == true){
            assert Exists.run(ID:"//*[contains(@class,'f-inline-message f-inline-message-info')]//A")==1, "Error - 'Message not displayed"
        } else {
            assert Exists.run(ID:"//*[contains(@class,'f-inline-message f-inline-message-info')]//A")==0, "Error - 'Message should not be displayed but it is displayed"
        }
        
        if(params."Click on Link" == true){
            Click.run(ID:"//*[contains(@class,'f-inline-message f-inline-message-info')]//A")
        }
    }
}