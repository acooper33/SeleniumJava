package actions.ViewIdea30;

import actions.selenium.*

class SetVotingonViewIdea3{
    public void run(def params){
        
        def vote
        if(params."Promote or Demote" == "Promote"){
            vote = "up"
        } else {
            vote = "down"
        }
        Click.run(ID:"//*[@class='f-idea-page-main']//*[contains(@class,'f-view-idea-${vote}-vote f-vote')]")
    }
}