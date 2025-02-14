package actions.IdeaBoard;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyStacksBIW{
    public void run(def params){
        def verify = [:]
        if(params."Placement Number"){verify.ID = "//*[contains(@class,'fractal-best-idea')]/DIV[contains(@class,'f-stack-wrapper')]/DIV[@class ='f-best-idea-stack  '][${params."Placement Number"}]//DIV[contains(@class,'f-stack-title')]/SPAN[contains(.,'${params."Stack"}')]"}
    	else{verify.ID = "//DIV[@class ='f-best-idea-stack  ']//DIV[contains(@class, 'f-stack-title')]/SPAN[contains(.,'${params."Stack"}')]"}
        
        verify.IDChildren = []
        if(params."Idea Count"){verify.IDChildren << "./../SPAN[contains(.,'${params."Idea Count"}')]"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)
    }
}