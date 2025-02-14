package actions.PipelineTopIdeas;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.utils.Elements
import actions.selenium.Browser

class VerifyIdeaFlyoverTopIdeas{
    public void run(def params){
        def verify = [:]
        //verify.ID = "//DIV[contains(@class,'pipelineViewRollover') and contains(@id, 'idea')]/A[@class='idea-title' and contains(.,'${params."Idea Title"}')]/../"
        verify.ID = "//DIV[contains(@class,'pipelineViewRollover') and contains(@id, 'idea')]"
        verify.IDChildren = []
        
        if(params."Idea Title"){verify.IDChildren << "./A[@class='idea-title' and contains(.,'${params."Idea Title"}')]"}
        if(params."Submitter"){verify.IDChildren << "./DIV[@class='idea-member']/DIV[@class='member-description']/A[contains(.,'${params."Submitter"}')]"}
        if(params."Date Created"){verify.IDChildren << "./DIV[@class='idea-creation']/SPAN[contains(.,'${params."Date Created"}')]"}
        if(params."Status"){verify.IDChildren << "./DIV[@class='idea-status']/SPAN[contains(.,'${params."Status"}')]"}
        if(params."Category"){verify.IDChildren << "./DIV[@class='idea-category']/SPAN[contains(., '${params."Category"}')]"}
        if(params."Idea Description"){
            def item = Elements.find(ID:"//DIV[contains(@class,'pipelineViewRollover') and contains(@id, 'idea')]/DIV[@class='idea-description']", Browser.Driver)
            println("Text>>")
            println(item.getText())
            verify.IDChildren << "./DIV[@class='idea-description' and contains(., '${params."Idea Description"}')]"
        
        }
        if(params."Votes"){verify.IDChildren << "./DIV[@class='f-idea-score-footer ']/DIV[@class='f-idea-score-scores']/DIV[@class='f-idea-score-footer-item' and contains(@data-votes, '${params."Votes"}')]"}
        if(params."Comments"){verify.IDChildren << "./DIV[@class='f-idea-score-footer ']/DIV[@class='f-idea-score-scores']/DIV[@class='f-idea-score-footer-item' and contains(@data-comments, '${params."Comments"}')]"}
        verify.Timeout=15
        VerifyNumberOfMatches.run(verify)
        sleep(3000)
    }
}