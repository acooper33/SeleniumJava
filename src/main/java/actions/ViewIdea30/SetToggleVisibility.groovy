package actions.ViewIdea30;

import actions.selenium.Click
import actions.selenium.Exists

class SetToggleVisibility{
    public void run(def params){
        
        if(params."Hidden Idea Message Displayed"==true){
            assert Exists.run(ID:"//*[contains(@class,'f-idea-hidden-banner')]//*[text()='This ${params."Idea Name"} is hidden']")==1, "Error - 'Hidden Message not displayed"
        }else if(params."Hidden Idea Message Displayed"==false){
            assert Exists.run(ID:"//*[contains(@class,'f-idea-hidden-banner')]//*[text()='This ${params."Idea Name"} is hidden']")==0, "Error - 'Idea is hidden"            
        }
        
        if(params."Toggle Visibility"==true){
            Click.run(ID:"//*[@id='f-toggle-visible']")
            sleep(2000)
        }
    }
}