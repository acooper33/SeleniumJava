package actions.NGAViewIdea;
import actions.selenium.utils.VerifyNumberOfMatches
import actions.common.*

class VerifyCommentInNGAViewIdeaPage{
    public void run(def params){
        
        NGAViewIdeaCommon.NavigateTab(Tab:"Description")
        
        //Map all values that will be used for verification for that instance
        def verify = [:]
        verify.IDChildren = []
        
        if(params."Comment Section"=="Reply"){
            verify.ID= "//*[contains(@class,'reply_list')]//*[contains(text(),'${params."Comment"}')]"
        } else {
            if(params."Comment Type"=="Admin"){
            	verify.ID= "//DIV[not(contains(@id,'pinned-comment')) and @class='regular-comment']//*[contains(@class,'comment-main-text admin-comment-text') and contains(.,'${params."Comment"}')]"
            }else{
            	verify.ID= "//DIV[not(contains(@id,'pinned-comment')) and @class='regular-comment']//*[contains(@class,'comment-main-text') and contains(.,'${params."Comment"}')]"
            }
        }
        
        if(params."Comment Type"=="Private" || params."Comment Type"=="Submitter Q&A"){verify.IDChildren << "./../..//LEGEND[contains(.,'${params."Comment Type"}')]"}
        if(params."Comment Type"=="Public"){
            println("We are in Public---------")
            verify.IDChildren << "./../../*[1][not(fieldset) or not(legend)]"
		}
        if(params."User"){verify.IDChildren << "./parent::DIV//a[text()='${params."User"}']"}
        if(params."Attachment File"){verify.IDChildren << "./../..//A[text()='${params."Attachment File"}']"}
        if(params."Promote Score"){verify.IDChildren << "./../..//*[contains(@class,'comment-score-vote') and starts-with(.,'${params."Promote Score"}')]"}
        if(params."Demote Score"){verify.IDChildren << "./../..//*[contains(@class,'comment-score-demote') and starts-with(.,'${params."Demote Score"}')]"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        
        VerifyNumberOfMatches.run(verify)  
    }
}