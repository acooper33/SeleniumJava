package actions.ViewIdea;

import actions.selenium.Exists
import actions.selenium.Click

class SetSubscribeinViewIdeapage{
    public void run(def params){
        if(params.Subscribe){
            if (Exists.run(ID:"//*[text()='Subscribe' and @id='bi-idea-subscribe']",Timeout:5)==1){
                Click.run(ID:"//*[text()='Subscribe' and @id='bi-idea-subscribe']")
            }
        }
        else{
            if (Exists.run(ID:"//*[text()='Subscribed' and @id='bi-idea-subscribe']",Timeout:5)==1){
                Click.run(ID:"//*[text()='Subscribed' and @id='bi-idea-subscribe']")
            }
        }
    }
}