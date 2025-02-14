package actions.Memo;

import actions.selenium.Click

class AccessMemofromTopIdeas{
    public void run(def params){
        
        if(params."Click on Title or Code"=="Title"){
           Click.run(ID:"//DIV[contains(@class,'f-idea f-idea-large')]//DIV[contains(@class,'f-idea-title')]/SPAN[contains(.,'${params."Title or Code Number"}')]") 
        } else {
           Click.run(ID:"//DIV[contains(@class,'f-idea f-idea-large')]//*[@class='f-card-link' and text()='${params."Title or Code Number"}']") 
        }        
    }
}