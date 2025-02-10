package actions.Webstorm;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Click
import actions.selenium.Exists

class VerifyChallengeBriefAnswerforaWebstorm{
    public void run(def params){

        if(Exists.run(ID:"//*[contains(@id,'commen')]//*[text()='${params."Question"}']/parent::DIV/parent::DIV/parent::DIV/parent::DIV//*[@class='comment-animation-placeholder']//*[contains(@id,'comment')]//*[text()='${params."Answer"}']")==0){
        Click.run(ID:"//*[contains(@id,'commen')]//*[text()='${params."Question"}']/../../..//*[@class='total-nested-comments']")}
        //Map all values that will be used for verification for that instance
        def verify = [:]
        verify.ID = "//*[contains(@id,'commen')]//*[text()='${params."Question"}']/parent::DIV/parent::DIV/parent::DIV/parent::DIV//*[@class='comment-animation-placeholder']//*[contains(@id,'comment')]//*[text()='${params."Answer"}']"        
        verify.IDChildren = []
        if(params."User"){verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV//*[@class='name-and-date-wrapper']//A[text()='${params."User"}']"}
        if(params."Administrator or Sponsor"){verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV//*[@class='fractal-member-badge' and contains(.,'${params."Administrator or Sponsor"}')]"}
        if(params."Date"){verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV//*[@class='name-and-date-wrapper' and contains(.,'${params."Date"}')]"}
        if(params."Placement Number"){
            params."Number of Matches"=1
            verify.ID = "//*[contains(@id,'commen')]//*[text()='${params."Question"}']/parent::DIV/parent::DIV/parent::DIV/parent::DIV//*[@class='comment-animation-placeholder'][${params."Placement Number"}]//*[contains(@id,'comment')]//*[text()='${params."Answer"}']"
            VerifyNumberOfMatches.run(verify)
        }else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
    }
}