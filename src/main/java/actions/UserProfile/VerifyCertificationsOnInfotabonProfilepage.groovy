package actions.UserProfile;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyCertificationsOnInfotabonProfilepage{
    public void run(def params){

        def verify = [:]
        verify.ID = "//*[@class='fa fa-certificate']/following-sibling::SPAN[text()='${params."Certification"}']"
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify) 
    }
}