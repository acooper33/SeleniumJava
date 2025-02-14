package actions.IdeaBoard;

import actions.selenium.Click

class ClearFiltersinIdeaBoards30{
    public void run(def params){        
        Click.run(ID:"//*[starts-with(@class,'ideaboard-filter-bar')]//span[starts-with(@class, 'ideaboard-filter-clear')]", "Type of Click":"Javascript") //change to the class name, when GB updates
    	sleep(3000)
    }
}