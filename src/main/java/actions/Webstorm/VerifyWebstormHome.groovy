package actions.Webstorm;

import actions.selenium.VerifyText
import actions.selenium.Exists

class VerifyWebstormHome{
    public void run(def params){
        
        if(params."Is it Idea Box?" == true){
            VerifyText.run(ID:"//*[@id='homepage-hero-render']//DIV[contains(@id,'name')]/DIV",Text:params."Initiative Title")
        }
        else{
            if(Exists.run(ID:"//*[@id='hh-headline']")>0){
                VerifyText.run(ID:"//*[@id='hh-headline']/H2",Text:params."Initiative Title")
            } else {
                VerifyText.run(ID:"//*[@id='homepage-htmlpreview-name']/DIV",Text:params."Initiative Title")
            }            
        }
        if(params."Initiative Description"){
                assert Exists.run(ID:"//*[text()='${params."Initiative Description"}']")>0,"Error - Initiative Description text not found"
        }
    }
}