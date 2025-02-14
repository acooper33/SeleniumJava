package actions.ViewIdeaComment;

import actions.selenium.Click
import actions.common.ViewIdeaCommon

class RemoveCommentinViewIdeaPageSubmitter{
    public void run(def params){
        
       ViewIdeaCommon.NavigateTab(Tab:"Description")
       
       Click.run(ID:"//*[not(contains(@id,'pinned-comment')) and @class='regular-comment']//*[contains(@class,'comment-main-text') and text()='${params."Comment to Remove"}']/../..//*[contains(@id,'delete_comment_icon')]")        
       sleep(2000)
       if(params."Action"=="Cancel"){Click.run(ID:"//*[@class='bimodal-secondary']")}
       else{Click.run(ID:"//*[@class='green_btn_center']")}
       sleep(2000)
        
    }
}