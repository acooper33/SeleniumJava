package actions.ViewIdeaComment;

import actions.ViewIdeaComment.SetCommentEditMenu

class GetCommentLink{
    public static run(def params){
     
        def link
        link = SetCommentEditMenu.run("Comment to Edit":params."Comment to Copy Link from","Menu Option":params."Menu Option")
        println(link)
        return link
    }
}