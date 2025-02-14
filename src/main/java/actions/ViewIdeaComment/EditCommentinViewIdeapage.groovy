package actions.ViewIdeaComment;

import actions.common.ViewIdeaCommon
import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SetCheckBox
import actions.selenium.SendKeys
import actions.selenium.SetFocus

class EditCommentinViewIdeapage{
    public void run(def params){
        ViewIdeaCommon.NavigateTab(Tab:"Description")
        
        Click.run(ID:"//*[not(contains(@id,'pinned-comment')) and @class='regular-comment']//*[contains(@class,'comment-main-text') and text()='${params."Comment to Edit"}']/../..//*[contains(@class,'fa fa-pencil-square icon')]")

        //Because there is a trailing space after clearing, we need to remove it as well
        SetText.run(ID:"//*[@class='edit_div ui-autocomplete-input']",Text:params.Comment, "Type of Clear":"Cut")
        //SetFocus.run(ID:"//*[@class='edit_div ui-autocomplete-input']")
        //Click.run(ID:"//*[@class='edit_div ui-autocomplete-input']")
        //SendKeys.run(ID:"//*[@class='edit_div ui-autocomplete-input']",Key:"BACK_SPACE")
        Click.run(ID:"//*[contains(@class,'fa fa-check-square')]")
        sleep(2000)
    }
}