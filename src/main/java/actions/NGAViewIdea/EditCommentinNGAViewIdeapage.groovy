package actions.NGAViewIdea;

import actions.selenium.Click
import actions.selenium.SendKeys
import actions.selenium.SetText
import actions.common.NGAViewIdeaCommon




class EditCommentinNGAViewIdeapage{
    public void run(def params){
        NGAViewIdeaCommon.NavigateTab("Tab":"Description")
        Click.run(ID:"//*[not(contains(@id,'pinned-comment')) and @class='regular-comment']//*[contains(@class,'comment-main-text') and text()='${params."Comment to Edit"}']/../..//*[@class='fa fa-pencil-square icon']")
		SetText.run(ID:"//*[starts-with(@id,'edit-comment-wrapper')]", Text:params."New Comment Text")
        sleep(1000)
        if (params.Action=='Save'){
            Click.run(ID:"//*[@id='dummy-comment-icons']/LI/I[contains(@class,'fa-check-square')]")//, "Type of Click":"Javascript")
            sleep(2000)
        }
        
    }
}