package actions.IdeaBoard;

import actions.selenium.Click
import actions.selenium.Exists

class SetIdeainIdeaBoardPage{
    public void run(def params){
        def parentID = "//*[@class='idea-title' and text()='${params."Idea Name"}']"
        
        if(params.Vote){
            if(params.Vote=="Up"){Click.run(ID:parentID+"/parent::A/parent::DIV/parent::DIV/parent::DIV//DIV[@arrow='promote']","Type of Click":"Javascript")}
            else if(params.Vote=="Down"){Click.run(ID:parentID+"/parent::A/parent::DIV/parent::DIV/parent::DIV//DIV[@arrow='demote']","Type of Click":"Javascript")}
            else{Click.run(ID:parentID+"/parent::A/parent::DIV/parent::DIV/parent::DIV//SPAN[text()='Clear Vote']","Type of Click":"Javascript")}
            sleep(1000)
        }
        if(params.Favorite!=null){
            if(params.Favorite){
                if (Exists.run(ID:parentID+"/parent::A/parent::DIV/parent::DIV/parent::DIV//DIV[@class='board-idea-fav']",Timeout:5)==1){
                    Click.run(ID:parentID+"/parent::A/parent::DIV/parent::DIV/parent::DIV//DIV[@class='board-idea-fav']")
                }
            }
            else{
                if (Exists.run(ID:parentID+"/parent::A/parent::DIV/parent::DIV/parent::DIV//DIV[@class='board-idea-fav is-favorite']",Timeout:5)==1){
                    Click.run(ID:parentID+"/parent::A/parent::DIV/parent::DIV/parent::DIV//DIV[@class='board-idea-fav is-favorite']")
                }
            }
            sleep(1000)
        }
    }
}