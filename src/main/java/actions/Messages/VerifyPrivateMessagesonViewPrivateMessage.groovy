package actions.Messages;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Exists

class VerifyPrivateMessagesonViewPrivateMessage{
    public void run(def params){
       //Map all values that will be used for verification for that instance
        def verify = [:]
        verify.ID= "//*[@id='messages_list']//a[contains(@href,'profile') and contains(text(),'${params."Sender"}')]"        
        verify.IDChildren = []
        if(params."Message"){verify.IDChildren << "./../../../..//TD[contains(.,'${params."Message"}')]"} 
        if(params."Date"){verify.IDChildren << "./../..//DIV[contains(text(),'${params."Date"}')]"} 
        if(params."Time"){verify.IDChildren << "./../..//DIV[contains(text(),'${params."Time"}')]"}
        if(params."Image"!=null){
            def img
            if(params."Image"){img = "/IMG[contains(@src,'getfile.php')]"}
            else{img = "/IMG[contains(@src,'ct/images/profile')]"}
            verify.IDChildren << "./../../../../${img}"
        }
        if(params."Subject"){assert Exists.run(ID:"//*[@id='article']//div[text()='${params."Subject"}']") == 1,"Error - ${params."Subject"} subject is incorrect"}

        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)
    }
}