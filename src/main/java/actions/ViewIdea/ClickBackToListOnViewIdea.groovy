package actions.ViewIdea;

import actions.selenium.Click

class ClickBackToListOnViewIdea{
    public void run(def params){
    	//Click.run(ID:"//A[@id='view_idea_2_back_link' and contains(.,'Back To List')]", "Type of Click":"Javascript")
        Click.run(ID:"//A[@id='view_idea_2_back_link']", "Type of Click":"Javascript")
    }
}
