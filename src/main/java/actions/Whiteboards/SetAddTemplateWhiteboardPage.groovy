package actions.Whiteboards;

import actions.selenium.Click
import actions.WebstormHomepage.SetActionOnChangeBackgroundModal


class SetAddTemplateWhiteboardPage{
    public void run(def params){
        if(params."Tab"){
            Click.run(ID:"//DIV[contains(@class,'f-tabs-header-container')]//BUTTON//*[starts-with(.,'${params."Tab"}')]")
        }
        if(params."Template Title"){
            Click.run(ID:"//*[@class='f-modal-body']/*[contains(@class,'f-template-main')]//UL/LI[contains(@class,'f-template-list-item')]//DIV[contains(@class,'f-template-item')]//SPAN[@class='f-template-title' and .='${params."Template Title"}']")
            sleep(2000)
            //SetActionOnChangeBackgroundModal.setAction(Action:params."Action")
        }
    }
}