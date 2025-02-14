package actions.ViewIdeaComment;

import actions.selenium.Click

class SetChangeCommentPermissionModal{
    public void run(def params){
        
        Click.run(ID:"//*[@class='f-comment-permission-row']//*[text()='${params."Permission"}']/../..//INPUT[contains(@id,'radio')]/..")  
        if(params.Action){
            if(params."Action"=="Update"){
                Click.run(ID:"//*[@data-test='modal-footer-submit' and .='${params."Action"}']")     
            } else {
              Click.run(ID:"//*[@class='title' and text()='Change Comment Permission']/../..//*[@data-test='modal-footer-cancel' and .='Cancel']")    
            }
        }
    }
}