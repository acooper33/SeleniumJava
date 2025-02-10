package actions.PipelineStepsView;

import actions.selenium.utils.VerifyNumberOfMatches


class VerifyIdeainPipelineStepsViewpage{
    public void run(def params){
        //Map all values that will be used for verification for that instance
        def verify = [:]
        if(params."Placement Number"){verify.ID = "(//*[@id='content-inside'])[${params."Placement Number"}]/DIV//P[contains(.,'${params."Idea Name"}')]"}	
        else{verify.ID = "//*[@id='content-inside']/DIV//P[contains(.,'${params."Idea Name"}')]"}
        
        verify.IDChildren = []
        if(params."Idea ID"){verify.IDChildren << ".//A[normalize-space()='${params."Idea ID"}']"}
        if(params."Step Name idea belongs to"){verify.IDChildren << "./../../../../../../../../../../../..//SPAN[@class='step_header_name' and text()='${params."Step Name idea belongs to"}']"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        verify.Timeout=15
        VerifyNumberOfMatches.run(verify) 
    }
}