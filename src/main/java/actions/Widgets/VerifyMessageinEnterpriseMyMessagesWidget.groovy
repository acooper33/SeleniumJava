package actions.Widgets;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Click

class VerifyMessageinEnterpriseMyMessagesWidget{
    public void run(def params){
        def verify = [:]
        verify.ID = "//*[@id='private_messages_content']//a[contains(@href,'view_private_message') and text()='${params."Subject"}']"        
        verify.IDChildren = []
        if(params."Body"){verify.IDChildren << "./../../../..//*[@class='my_messages_body' and text()='${params."Body"}']"}
        if(params."Sender"){verify.IDChildren << "./../../..//*[@class='my_messages_user' and .='${params."Sender"}']"}
        if(params."Sender Image Displayed" !=null){
            def img
            if(params."Sender Image Displayed"){img = "//*[contains(@href,'ct_profile.php')]/IMG[contains(@src,'getfile.php')]"}
            else {img = "//*[contains(@href,'ct_profile.php')]/IMG[contains(@src,'images/profile')]"}
            verify.IDChildren << "./../../..${img}"
        }
        if(params."Date"){verify.IDChildren << "./../../../..//*[@class='my_messages_time' and contains(text(),'${params."Date"}')]"}
        if(params."Time"){verify.IDChildren << "./../../../..//*[@class='my_messages_time' and contains(text(),'${params."Time"}')]"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)        
        if(params."Access Message"==true){
            Click.run(ID:"//*[@id='private_messages_content']//a[contains(@href,'view_private_message') and text()='${params."Subject"}']")}
    }
}
