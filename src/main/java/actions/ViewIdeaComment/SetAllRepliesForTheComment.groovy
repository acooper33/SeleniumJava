package actions.ViewIdeaComment;

import actions.selenium.Click

class SetAllRepliesForTheComment{
    public void run(def params){
        
        Click.run(ID:"//*[@data-test='f-test-comment-wrapper']//*[text()='${params."Parent Comment"}']/../../../../../following-sibling::DIV[1]//*[contains(text(),'View ${params."Number of Replies"}')]")
        
    }
}