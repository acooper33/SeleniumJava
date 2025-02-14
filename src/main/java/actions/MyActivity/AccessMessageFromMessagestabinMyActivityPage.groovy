package actions.MyActivity;

import actions.selenium.Click

class AccessMessageFromMessagestabinMyActivityPage{
    public void run(def params){

        //Map all values that will be used for access of that instance
        def set = [:]
        set.ID= "//*[contains(@id,'message_title')]/A[text()='${params."Subject"}']"        
        set.IDChildren = []
        if(params."Message"){set.IDChildren << "./../../../..//SPAN[@class='profile_my_messages_body' and contains(text(),'${params."Message"}')]"}
        if(params."Date"){set.IDChildren << "./../../../..//SPAN[@class='profile_my_messages_time' and text()='${params."Date"}']"}        
        if(params."Sender"){set.IDChildren << "./../../..//SPAN[@class='my_messages_user' and .='${params."Sender"}']"}       
        Click.run(set)
    }
}
