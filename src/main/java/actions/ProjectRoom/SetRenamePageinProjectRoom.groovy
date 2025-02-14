package actions.ProjectRoom;

import actions.selenium.*

class SetRenamePageinProjectRoom{
    public void run(def params){
        
         SetText.run(ID:"//*[@id='f-rooms-item-name']", Text:params."New Page Name", "Type of Clear":"Cut")
         if(params."Action"=="Cancel"){
            Click.run(ID:"//*[@data-test='modal-footer-cancel']")
        } else {
            Click.run(ID:"//*[@data-test='modal-footer-submit']/*[text()='${params."Action"}']")
            sleep(2000)
        }
    }
}