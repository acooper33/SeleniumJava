package actions.ViewIdeaComment;

import actions.selenium.Click
import actions.common.ViewIdeaCommon
import actions.selenium.SetText

class ReportCommentAbuseinViewIdeapage{
    public static void run(def params){
        ViewIdeaCommon.NavigateTab(Tab:"Description")
        
        Click.run(ID:"//*[not(contains(@id,'pinned-comment')) and @class='regular-comment']//*[contains(@class,'comment-main-text') and text()='${params."Comment to Report"}']/../..//*[contains(@id,'report_abuse_comment_icon')]")
        SetText.run(ID:"//*[@id='abuse-desc']",Text:params."Abuse description")
        if(params."Action"){
            if(params."Action"=="Cancel"){Click.run(ID:"//*[@id='report-abuse-popup']//*[text()='Cancel']")}
            else{Click.run(ID:"//*[@id='report-abuse-popup']//*[text()='Send']")}
        }
    }
}