package actions.ViewIdeaComment;

import actions.selenium.Click

class SetCommentEditMenu{
    public void run(def params){
        
        def path
        path = "//*[@data-test='f-test-comment-wrapper']/*[contains(.,'${params."Comment to Edit"}')]/../..//SPAN[@class='f-web-dropdown']"
        Click.run(ID:"${path}","Type of Click":"Move to Element")
        Click.run(ID:"${path}//*[@class='f-edit-comment-options' and text()='${params."Menu Option"}']", "Handle Stale Element":true)    
        
        if(params."Delete Action"){
            if(params."Delete Action"=="Delete"){
                Click.run(ID:"//*[@id='clickToConfirmOkButton']")
            } else {
                Click.run(ID:"//*[@id='clickToConfirmCancelButton']")
            }
        }
    }
}