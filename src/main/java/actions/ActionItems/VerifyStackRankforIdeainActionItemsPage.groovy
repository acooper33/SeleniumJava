package actions.ActionItems;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyStackRankforIdeainActionItemsPage{
    public void run(def params){
        
        def verify = [:]
        verify.ID = "//*[@class='idea_rank_num' and text()='${params."Rank"}']/../../*[not(contains(@style,'none'))]//SPAN[@class='stack-rank-idea-title'and text()='${params."Idea"}']"
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify) 
    }
}