package actions.Webstorm;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyChallengeBriefQuestionforaWebstorm{
    public void run(def params){
        def verify = [:]
        verify.ID = "//*[contains(@id,'commen')]//*[text()='${params."Question"}']"        
        verify.IDChildren = []
        if(params."User"){verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV/parent::DIV//*[@class='name-and-date-wrapper']//A[text()='${params."User"}']"}
        if(params."Administrator or Sponsor"){verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV/parent::DIV//*[@class='fractal-member-badge' and contains(.,'${params."Administrator or Sponsor"}')]"}
        if(params."Date"){verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV/parent::DIV//*[@class='name-and-date-wrapper' and contains(.,'${params."Date"}')]"}
        if(params."Total Answers"){verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV/parent::DIV//*[@class='total-nested-comments' and contains(.,'${params."Total Answers"}')]"}
        if(params."Placement Number"){
            params."Number of Matches"=1
            //verify.ID = "//*[contains(@class,'fractal-comment-box fractal-comment-box-top-parent comment-hidden')][${params."Placement Number"}]//*[contains(@id,'commen')]//*[text()='${params."Question"}']"
            verify.ID = "//*[contains(@id,'comments-comment-list')]//DIV[contains(@class,'comment-box')][${params."Placement Number"}]//*[contains(@id,'comment')]//*[.='${params."Question"}']"            
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
    }
}