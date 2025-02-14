package actions.ViewIdeaComment;

import actions.common.ViewIdeaCommon
import actions.selenium.SetText
import actions.selenium.SetCheckBox
import actions.selenium.Click


class ReplytoCommentinViewIdeapage{
    public void run(def params){
        ViewIdeaCommon.NavigateTab(Tab:"Description")
        
        if(params."Comment to Reply to"){
            Click.run(ID:"//*[not(contains(@id,'pinned-comment')) and @class='regular-comment']//*[contains(@class,'comment-main-text') and text()='${params."Comment to Reply to"}']/../..//*[contains(@class,'fa fa-reply icon')]","Type of Click": "Javascript")
        }
        SetText.run(ID:"//*[@class='reply_comment_input ui-autocomplete-input']",Text:params.Comment)
        SetCheckBox.run(ID:"//*[@class='reply_comment_input ui-autocomplete-input']/..//input[@name='admin_comment_flag']",Check:params."Admin Comment")
        if(params.Action=="Post"){Click.run(ID:"//*[@id='bi-reply-comment-button']")}
        else{Click.run(ID:"//*[@id=bi-comment-cancel-button']")}
        sleep(2000)
    }
}