package actions.Widgets;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifySponsorWidget{
    public void run(def params){

        def verify = [:]
        verify.ID = "//*[@id='sponsor-screen-name' and text()='${params."Sponsor Title"}']"
        verify.IDChildren = []
        if(params."Job Title"){
            verify.IDChildren << "./../../*[@id='sponsor-job-title' and text()='${params."Job Title"}']"
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify) 

    }
}