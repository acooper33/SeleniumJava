package actions.ViewIdea30;

import actions.selenium.Exists
import actions.selenium.Click

class SetSubscribeinViewIdea30Page{
    public void run(def params){
        
         if(params.Subscribe == true){
                Click.run(ID:"//*[@id='button-subscribe-idea' and .='Subscribe']")
         } else {
             Click.run(ID:"//*[@id='button-subscribe-idea' and .='Subscribed']")
         }
    }
}
        