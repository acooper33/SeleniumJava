package actions.IdeaBoard;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyStepsinPipelineStepsViewforEndUsers{
    public void run(def params){

        def verify = [:]
        if(params."Placement Number"){verify.ID = "//*[@class='fractal-widget-pipelineView']/descendant::DIV[@class='step lane'][${params."Placement Number"}]/DIV[contains(text(),'${params."Step"}')]"}	
        else{verify.ID = "//*[@class='step lane']/DIV[contains(text(),'${params."Step"}')]"}
        
        verify.IDChildren = []
        if(params."Idea Count"){verify.IDChildren << "./../*[contains(text(),'(${params."Idea Count"})')]"}
        if(params."Stage in which this step is displayed"){verify.IDChildren << "./../../..//SPAN[contains(text(),'${params."Stage in which this step is displayed"}')]"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify) 
    }
}