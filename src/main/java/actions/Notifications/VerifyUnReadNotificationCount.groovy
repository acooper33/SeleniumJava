package actions.Notifications;

import actions.selenium.Exists

class VerifyUnReadNotificationCount{
    public void run(def params){

        if(params."Unread Notification Count"=="0"){
            assert Exists.run(ID:"//*[@id='notifications']//*[@class='global-nav-badge' and contains(@style,'none')]")==0,"Incorrect UnRead Notification Count"   
        }else{
            assert Exists.run(ID:"//*[@id='notifications']//*[@class='global-nav-badge' and text()='${params."Unread Notification Count"}']")==1,"Incorrect UnRead Notification Count"  
        }
    }
}