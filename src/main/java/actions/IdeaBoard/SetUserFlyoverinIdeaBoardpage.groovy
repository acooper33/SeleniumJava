package actions.IdeaBoard;

import actions.selenium.MouseOver
import actions.selenium.Click

class SetUserFlyoverinIdeaBoardpage{
    public void run(def params){
        
        MouseOver.run(ID:"//*[@class='idea-title' and text()='${params."Idea Name"}']/parent::A/parent::DIV/parent::DIV/parent::DIV//*[text()='${params."Username"}']")

        if (params.Action){         
            if(params.Action=="Follow or Unfollow"){
                Click.run(ID:"//*[@id='user-fly-follow-btn']")
            } else if (params.Action=="Profile") {
                Click.run(ID:"//*[@id='user-fly-profile-btn']")
            } else { 
                Click.run(ID:"//*[@id='user-fly-message-btn']")        
            }
        }
    }
}