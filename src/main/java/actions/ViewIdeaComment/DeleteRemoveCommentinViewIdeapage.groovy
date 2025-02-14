package actions.ViewIdeaComment;

import actions.selenium.Click
import actions.common.ViewIdeaCommon

class DeleteRemoveCommentinViewIdeapage{
   public void run(def params){
       ViewIdeaCommon.NavigateTab(Tab:"Description")
       
       Click.run(ID:"//*[not(contains(@id,'pinned-comment')) and @class='regular-comment']//*[contains(@class,'comment-main-text') and text()='${params."Comment to Delete or Remove"}']/../..//*[contains(@id,'delete_comment_icon')]")
       
       if(params."Replace or Permanent"=="Replace"){Click.run(ID:"//*[@id='comment_remove']")}
       else{Click.run(ID:"//*[@id='comment_delete']")}
       Click.run(ID:"//*[@class='green_btn_center']",Instance:1)
       sleep(2000)
       if(params."Action"=="Cancel"){Click.run(ID:"//*[@class='bimodal-secondary']",Instance:2)}
       else{Click.run(ID:"//*[@class='green_btn_center']",Instance:2)}
       sleep(2000)
   }
}