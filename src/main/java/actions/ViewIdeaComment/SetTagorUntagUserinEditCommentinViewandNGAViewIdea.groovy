package actions.ViewIdeaComment;

import actions.selenium.*
    
class SetTagorUntagUserinEditCommentinViewandNGAViewIdea{
    public void run(def params){
        
        def path
        path = "//*[@class='f-comment-input-textarea']/../*[contains(.,'${params."Comment"}')]"
        Click.run(ID:"${path}")
        if(params."Add or Remove"=="Add"){
            def tag = "@"+params.SearchText
            SetText.run(ID:"${path}", Text:tag, "Type of Clear":"None")
            sleep(3000)
            Click.run(ID:"//*[contains(@class,'f-comment-input-tagging-panel')]//*[contains(@class,'f-comment-input-memberlist-name') and (contains(text(),'${params."Email"}') or contains(text(), '${params."Username"}'))]")
            sleep(2000)
        } else {
            sleep(2000)
            SendKeys.run(ID:"${path}",Key:"BACK_SPACE")
        }        
    }
}