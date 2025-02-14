package actions.ViewIdeaComment;

import actions.selenium.Click
import actions.common.ViewIdeaCommon

class PromoteDemoteCommentinViewIdeapage{
    public void run(def params){
        ViewIdeaCommon.NavigateTab(Tab:"Description")
        
        if(params."Promote or Demote"=="Promote"){Click.run(ID:"//*[not(contains(@id,'pinned-comment')) and @class='regular-comment']//*[contains(@class,'comment') and text()='${params."Comment"}']/../..//*[contains(@id,'promote_button')]")}
        else{Click.run(ID:"//*[not(contains(@id,'pinned-comment')) and @class='regular-comment']//*[contains(@class,'comment') and text()='${params."Comment"}']/../..//*[contains(@id,'demote_button')]")}
    }
}