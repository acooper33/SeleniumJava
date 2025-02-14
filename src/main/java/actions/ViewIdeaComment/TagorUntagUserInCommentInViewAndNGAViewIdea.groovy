package actions.ViewIdeaComment;

import actions.selenium.*

class TagorUntagUserInCommentInViewAndNGAViewIdea{
    public void run(def params){

        def path
        if(params."Comment Section"=="Reply"){
            path ="//*[starts-with(@id,'fractal-commenting-input-') and contains(@id,'reply')]"
        } else {
            path ="//*[starts-with(@id,'fractal-commenting-input--')]"
        }
        if(params."Add or Remove"=="Add"){
            def tag = "@"+params.SearchText
            SetText.run(ID:"${path}", Text:tag, "Type of Clear":"None")sleep(3000)
            Click.run(ID:"//*[contains(@class,'f-comment-input-tagging-panel')]//*[contains(@class,'f-comment-input-memberlist-name') and (contains(text(),'${params."Email"}') or contains(text(), '${params."Username"}'))]")
            sleep(2000)
        } else {
            SendKeys.run(ID:"${path}",Key:"BACK_SPACE")
            SendKeys.run(ID:"${path}",Key:"BACK_SPACE")
        }        
    }
}