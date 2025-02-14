package actions.MyActivity;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.common.MyActivityCommon
import actions.selenium.Click

class VerifySubmissionsinMyActivitypage{
    public void run(def params){
        //Go to Submissions tab
        MyActivityCommon.NavigateTab(Tab:"Submissions")
        
        //Map all values that will be used for verification for that instance
        def verify = [:]
        switch (params."Value Type to Verify"){
            case "POSTED IDEAS":
            	verify.ID= "//*[@id='posted_idea_header']/parent::DIV//*[text()='${params."Idea Name"}' and @class='landing_page_content_main_link']"
            	break            	
            case "IDEA DRAFT":
            	verify.ID= "//*[@id='draft_idea_header']/parent::DIV//*[text()='${params."Idea Name"}' and @class='landing_page_content_main_link']"
            	break
            case "COMMENT ON IDEAS":
            	verify.ID= "//*[@id='posted_comment_header']/parent::DIV//*[text()='${params."Idea Name"}' and @class='landing_page_content_main_link']"
            	break            
        }
        verify.IDChildren = []
        if(params."Value"){verify.IDChildren << "./following-sibling::DIV/*[contains(text(),'${params."Value"}')]"}
        if(params."Description"){verify.IDChildren << "./following-sibling::DIV[contains(.,'${params."Description"}')]"}
        if(params."Posted Ideas Comments number"){verify.IDChildren << "./parent::td//*[text()='${params."Posted Ideas Comments number"} comments']"}
        if(params."Posted Ideas Status"){verify.IDChildren << "./parent::td/following-sibling::td//*[contains(text(),'${params."Posted Ideas Status"}')]"}        
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        
        VerifyNumberOfMatches.run(verify)    
        if(params."Access Idea"==true){Click.run(verify)}
    }
}