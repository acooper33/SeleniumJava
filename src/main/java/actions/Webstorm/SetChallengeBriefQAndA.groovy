package actions.Webstorm;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.Exists

class SetChallengeBriefQAndA{
    public void run(def params){

        if(params."Question or Answer"=="Question"){      
            SetText.run(ID:"//*[contains(@class,'redactor-styles') and contains(@placeholder,'Post your question')]",Text:params."Text")
            if(Exists.run(ID:"//*[@class='redactor-box redactor-styles-on redactor-blur']")==1){
                Click.run(ID:"//*[contains(@class,'redactor-styles redactor-in redactor-in') and contains(@placeholder,'Post your question')]")
            }
        } else {            
            Click.run(ID:"//*[contains(@id,'comment')]/*[contains(text(),'${params."Question whose answer to be posted"}')]/../../..//DIV[@class='fractal-comment-btn']","Type of Click":"Javascript")
            Click.run(ID:"//*[contains(@id,'comment')]/*[contains(text(),'${params."Question whose answer to be posted"}')]/../../../..//*[contains(@class,'redactor-styles redactor-placeholder redactor-in redactor-in')]")
            SetText.run(ID:"//*[contains(@id,'comment')]/*[contains(text(),'${params."Question whose answer to be posted"}')]/../../../..//*[contains(@class,'redactor-styles redactor-placeholder redactor-in redactor-in')]",Text:params."Text")
            sleep(2000)
        }
        Click.run(ID:"//*[@id='postContent']")
        sleep(3000)
    }
}