package actions.IdeaBoard;

import actions.selenium.SetFocus
import actions.selenium.Click

class SetUserFlyoverinIdeaBoardpage30{
    public void run(def params){

        SetFocus.run(ID:"//*[contains(@class,'f-card-title')][text()='${params."Idea Name"}']/../..//*[contains(@class,'f-card-screenname')][normalize-space()='${params."Username"}']")
	    if(params.Action){
                Click.run(ID:"//*[contains(@class, 'flyover-link-item')][.='${params.Action}']", "Type of Click":"Javascript")
        }
    }
}