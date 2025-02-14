package actions.ViewIdeaComment;

import actions.selenium.*

class VerifyCommentCountintheHeader{
    public void run(def params){
       
       assert Exists.run(ID:"//*[@data-subclass='f-rnw-comments-header' and .='Comments (${params."Comment Count"})']") == 1,"Error - Incorect Comment Count"
    }
}