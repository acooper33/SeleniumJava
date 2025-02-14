package actions.ViewIdeaComment;

import actions.common.*
import actions.selenium.Click

class PromoteDemoteCommentinViewandNGAViewIdeapage{
    public void run(def params){
        
         if(params."View Idea or NGA"=="NGA"){
            NGAViewIdeaCommon.NavigateTab(Tab:"Description")
        } else {
            ViewIdeaCommon.NavigateTab(Tab:"Description")
        }
               
        Click.run(ID:"//*[@data-test='f-test-comment-wrapper']//*[text()='${params."Comment"}']/..//*[contains(@data-tooltip-id,'-${params."Promote or Demote".toLowerCase()}-tooltip')]/DIV[@data-class='reaction-count-button']")
    }
}
