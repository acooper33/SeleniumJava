package actions.ViewIdea;

import actions.selenium.Click

class SetVoteinViewIdeapage{
    public void run(def params){
        if(params.Vote=="Up"){Click.run(ID:"//*[@arrow='promote']")}
        else if (params.Vote=="Down")
        	{Click.run(ID:"//*[@arrow='demote']")}
        else if(params.Vote=="Clear Vote"){
            Click.run(ID:"//*[text()='Clear Vote']")
        }
        
    }
}