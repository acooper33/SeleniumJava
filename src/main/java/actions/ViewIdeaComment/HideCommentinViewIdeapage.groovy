package actions.ViewIdeaComment;

import actions.selenium.Click
import actions.common.ViewIdeaCommon

class HideCommentinViewIdeapage{
    public void run(def params){
        ViewIdeaCommon.NavigateTab(Tab:"Description")
        
        if(params.Hide){Click.run(ID:"//*[not(contains(@id,'pinned-comment')) and contains(@class,'-comment')]//*[contains(@class,'comment') and text()='${params."Comment to Hide"}']/../..//*[contains(@class,'fa fa-adjust')]")}
        else{Click.run(ID:"//*[not(contains(@id,'pinned-comment')) and contains(@class,'-comment')]//*[contains(@class,'comment') and text()='${params."Comment to Hide"}']/../..//*[contains(@class,'fa fa-circle')]")}
        sleep(2000)
    }
}