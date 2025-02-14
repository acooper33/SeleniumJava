package actions.PipelineTopIdeas;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyIdeaInTopIdeas{
    public void run(def params){
        def verify = [:]
        if(params."Placement Number") {verify.ID = "//*[@class = 'f-best-idea-stack   ']//DIV[contains(@class,'f-idea')][${params."Placement Number"}]/DIV[contains(@class,'f-idea-title')]/SPAN[contains(.,'${params."Idea Title"}')]"}
        else {verify.ID = "//*[@class ='f-best-idea-stack   ']//DIV[contains(@class,'f-idea')]/DIV[contains(@class,'f-idea-title')]/SPAN[contains(.,'${params."Idea Title"}')]"}
          
        verify.IDChildren = []
        if(params."Idea ID"){verify.IDChildren << "./..//A[text()='${params."Idea ID"}']"}
        if(params."Stack Name idea belongs to"){verify.IDChildren << "./../../../../..//DIV[contains(@class,'f-stack-header')]/DIV[contains(@class,'f-stack-title')]/SPAN[.= '${params."Stack Name idea belongs to"}']"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        verify.Timeout=15
        VerifyNumberOfMatches.run(verify)
    }
}