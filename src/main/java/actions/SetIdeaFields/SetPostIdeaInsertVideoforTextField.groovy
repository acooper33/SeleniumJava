package actions.SetIdeaFields;

import actions.selenium.Click
import actions.selenium.SetText

class SetPostIdeaInsertVideoforTextField{
    public void run(def params){
        Click.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]/..//DIV[@class='redactor-toolbar']/A[@aria-label='Video']")
        SetText.run(Text:params."Video Link",ID:"//*[@id='modal-video-input']", "Type of Clear":"Cut")
        if(params."Action"){
            if(params."Action"=="Insert"){Click.run(ID:"//*[@id='redactor-modal']//*[text()='Insert']")}
            else{Click.run(ID:"//*[@id='redactor-modal']//*[text()='Cancel']")}
        }
        sleep(1000)
        Click.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]","Type of Click":"Move to Element")
   	}
}
