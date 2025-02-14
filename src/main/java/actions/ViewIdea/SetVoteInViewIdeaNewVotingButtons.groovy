package actions.ViewIdea;

import actions.selenium.Click
import actions.selenium.Exists

class SetVoteInViewIdeaNewVotingButtons{
    public void run(def params){
        if(params.Vote == 'Promote'){
            Click.run(ID:"//DIV[@id='voting-component-render']//*[contains(@class,'f-vote-arrow-container')]//BUTTON[contains(@class, 'f-view-idea-up-vote')]", "Type of Click":"Javascript")
        }
        if(params.Vote == 'Demote'){
            Click.run(ID:"//DIV[@id='voting-component-render']//*[contains(@class,'f-vote-arrow-container')]//BUTTON[contains(@class, 'f-view-idea-down-vote')]", "Type of Click":"Javascript")
        }
        if(params."Expected Vote Count"){
            sleep(1000)
            assert Exists.run(ID:"//*[contains(@class,'f-vote-arrow-container')]/DIV[contains(@class, 'f-vote-count') and .='${params."Expected Vote Count"}']")==1, "Error - Unexpected Vote Count"
        }
    }
}