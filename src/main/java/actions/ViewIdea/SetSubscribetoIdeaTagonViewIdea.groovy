package actions.ViewIdea;

import actions.selenium.MouseOver
import actions.selenium.Click


class SetSubscribetoIdeaTagonViewIdea{
    public void run(def params){
        
        if(params."Tag Name"){
            MouseOver.run(ID:"//*[@id='idea-tags-container']//A[contains(text(),'${params."Tag Name"}')]")
            if(params."Click Subscribe/Unsubscribe"==true){
                Click.run(ID:"//A[@id='tag-fly-btn']")
                sleep(2000)
            }
        }
        
    }
}