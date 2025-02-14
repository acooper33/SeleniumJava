package actions.ViewIdea;

import actions.selenium.*

class SetnewVotinginViewIdeaPage{
    public void run(def params){
        
        if(params."Promote or Demote" == "Promote"){
        Click.run(ID:"//*[contains(@class,'f-view-idea-up-vote f-vote')]")
        } else {
             Click.run(ID:"//*[contains(@class,'f-view-idea-down-vote f-vote')]")
        }
    }
}