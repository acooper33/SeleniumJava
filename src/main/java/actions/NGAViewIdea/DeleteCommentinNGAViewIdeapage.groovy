package actions.NGAViewIdea;

import actions.selenium.Click
import actions.common.NGAViewIdeaCommon

class DeleteCommentinNGAViewIdeapage{
    public void run(def params){
        
        NGAViewIdeaCommon.NavigateTab(Tab:"Description")
        
        Click.run(ID:"//*[not(contains(@id,'pinned-comment')) and @class='regular-comment']//*[contains(@class,'comment-main-text') and contains(.,'${params."Comment to be Deleted"}')]/../..//*[contains(@tooltip-text,'Delete Comment')]")
        
        if(params."Action"=="Cancel"){Click.run(ID:"//*[@class='bimodal-secondary' and text()='Cancel']")}
        else{Click.run(ID:"//*[@class='green_btn_center']")}
        sleep(2000)
    }
}