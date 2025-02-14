package actions.Notifications;

import actions.selenium.Exists
import actions.selenium.*
    
class VerifyOpenActionItemCount{
    public void run(def params){
        
        if(params."Wait for AI Count"==true){
            ExplicitWait.run(ID:"//*[@class='f-nav-icon'][3]//*[not(starts-with(@aria-label,'Action Items')) and contains(@class,'fractal-button')]")
        }
        if(params."Open AI Count"=="0"){
            assert Exists.run(ID:"//*[starts-with(@aria-label,'Action Items')]")==0,"Incorrect Open AI Alert Count"   
        }else{
            assert Exists.run(ID:"//*[@class='f-nav-icon-count' and text()='${params."Open AI Count"}']")==1,"Incorrect Open AI alert Count"  
        }
    }
}