package actions.ViewIdeaComment;

import actions.common.ViewIdeaCommon
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyCommentinViewIdeapage{
    public void run(def params){
        ViewIdeaCommon.NavigateTab(Tab:"Description")
        
        //Map all values that will be used for verification for that instance
        def verify = [:]
        verify.IDChildren = []
        if(params."Comment Section"=="Pinned"){
            verify.ID= "//*[@id='pinned_admin_comment']//*[contains(@class,'comment-main-text') and text()='${params."Comment"}']"        
        }
        else if(params."Comment Section"=="Reply"){
            verify.ID= "//*[contains(@id,'reply_list')]//*[text()='${params."Comment"}']"
            if(params."Type of Comment"=="Private" || params."Type of Comment"=="Submitter Q&A"){verify.IDChildren << "./ancestor::fieldset/LEGEND[contains(.,'${params."Type of Comment"}')]"}
            else if(params."Type of Comment"=="General Access"){verify.IDChildren << "./../../../../../../../../..//*[@id='tab-content']//*[@id='comment_container']"}
            else if(params."Type of Comment"=="Administrator"){verify.IDChildren << "./parent::DIV[@class='comment-text-container admin-comment']"}
        }
        else{
            verify.ID= "//*[not(contains(@id,'pinned-comment')) and @class='regular-comment']//*[contains(@class,'comment-main-text') and .='${params."Comment"}']"
            if(params."Type of Comment"=="Administrator"){verify.IDChildren << "./parent::DIV/div[@id='comment-header-admin-comment']"}
            else if(params."Type of Comment"=="Private" || params."Type of Comment"=="Submitter Q&A"){verify.IDChildren << "./../../../LEGEND[contains(.,'${params."Type of Comment"}')]"}
            else if(params."Type of Comment"=="General Access"){verify.IDChildren << "./../../../../DIV[@id='comment_container']"}
        }
        if(params."User"){verify.IDChildren << "./parent::DIV//a[text()='${params."User"}']"}
        if(params."Attachment File"){verify.IDChildren << "./../..//A[text()='${params."Attachment File"}']"}
        if(params."Promote Score"){verify.IDChildren << "./../..//*[contains(@id,'_score') and .='${params."Promote Score"}']"}
        if(params."Demote Score"){verify.IDChildren << "./../..//*[contains(@id,'_score_demote') and .='${params."Demote Score"}']"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        
        VerifyNumberOfMatches.run(verify)  
    }
}