package actions.Webstorm;

import actions.selenium.Click
import actions.selenium.SetText


class SetTworkUpdate{
    public void run(def params){
        if(params."Update to set" && params.Action){
         	Click.run(ID:"//*[contains(@id,'twork')]//DIV[contains(.,'${params."Update to set"}')]/../following-sibling::DIV[@id='display_note_attachment']//A[contains(text(),'${params.Action}')]")

            //Click.run(ID:"//*[contains(@id,'twork')]//DIV[contains(.,'${params."Update to set"}')]/../../..//DIV[@id='display_note_attachment']//A[contains(text(),'${params.Action}')]")
            sleep(2000)
            if(params.Action=="Delete"){
            	Click.run(ID:"//*[@id='gen_message_popup']//INPUT[@value='OK']")
            	sleep(3000)
			}
            if(params.Action=="Comment"){
            	Click.run(ID:"//*[contains(@id,'comment') and @class='intialUpdatesComment']//DIV[contains(@id,'add_comment')]")
            	SetText.run(ID:"//*[contains(@id,'comment') and @class='intialUpdatesComment']//DIV[contains(@id,'add_comment')]", Text:params.Comment)
                Click.run(ID:"//A[contains(@id,'comment_submit')]")
            
        	}
        }
    }
}