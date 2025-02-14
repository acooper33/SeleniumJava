package actions.IdeaBoard;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyStagesinPipelineStepsViewforEndUsers{
    public void run(def params){

        def verify = [:]
        if(params."Placement Number"){verify.ID = "//*[@class='stage lane'][${params."Placement Number"}]//*[contains(text(),'${params."Stage"}')]"}	
        else{verify.ID = "//*[@class='stage lane']//*[contains(text(),'${params."Stage"}')]"}

        verify.IDChildren = []
        if(params."Idea Count"){verify.IDChildren << "./../*[contains(text(),'(${params."Idea Count"})')]"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify) 
    }
}