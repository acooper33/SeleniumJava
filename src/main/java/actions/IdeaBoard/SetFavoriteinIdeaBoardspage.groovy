package actions.IdeaBoard;

import actions.selenium.Click

class SetFavoriteinIdeaBoardspage{
    public void run(def params){
        
        Click.run(ID:"//*[@class='f-card-title' and text()='${params."Idea Name"}']/../..//*[contains(@class,'f-idea-favorite-circle')]","Type of Click":"Javascript") 
    }
}