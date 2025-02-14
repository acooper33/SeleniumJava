package actions.ViewIdeaComment;

import actions.selenium.Click
import actions.common.ViewIdeaCommon

class RestoreRemovedCommentViewIdea{
    public void run(def params){
    	
        ViewIdeaCommon.NavigateTab(Tab:"Description")
        
        Click.run(ID:"//UL[@id='dummy-comment-icons']/LI/I[contains(@id,'delete_comment_icon')]")
        sleep(1000)
    }
}