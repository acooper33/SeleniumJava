package actions.MyActivity;

import actions.common.MyActivityCommon
import actions.selenium.Click

class AccesstabsforMessagesinMyActivityPage{
    public void run(def params){

        MyActivityCommon.NavigateTab(Tab:"Messages")
        sleep(4000)
        if(params."Select Tab"=="All"){
            Click.run(ID:"//*[@id='my_private_messages_all']/A")
        }else if(params."Select Tab"=="Unread"){        	
            Click.run(ID:"//*[@id='my_private_messages_unread']/A")
        }else if(params."Select tab"=="Sent"){            
            Click.run(ID:"//*[@id='my_private_messages_sent']/A")
        } else {Click.run(ID:"//*[@id='my_private_messages_new_message']/A")}   
    }
}