package actions.PipelineTopIdeas;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyIdeainMyListTopIdeas{
    public void run(def params){
        def verify = [:]
        if(params."Placement Number"){
            verify.ID = "//*[@class='f-best-idea-right-wing']//DIV[contains(@class,'f-idea')][${params."Placement Number"}]/DIV[contains(@class,'f-idea-title')]/SPAN[contains(.,'${params."Idea Title"}')]"
        }else {
            verify.ID = "//*[@class='f-best-idea-right-wing']//DIV[contains(@class,'f-idea')]/DIV[contains(@class,'f-idea-title')]/SPAN[contains(.,'${params."Idea Title"}')]"
        }
        verify.IDChildren = []
        if(params."Idea ID"){verify.IDChildren << ".//A[text()='${params."Idea ID"}']"}
        if(params."My List Name"){verify.IDChildren << "./../../../../../..//DIV[contains(@class,'f-best-idea-right-wing')]/H2[text()='${params."My List Name"}']"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        verify.Timeout=15
        VerifyNumberOfMatches.run(verify)
	}
}