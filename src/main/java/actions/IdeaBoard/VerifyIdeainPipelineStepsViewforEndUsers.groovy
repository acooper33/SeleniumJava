package actions.IdeaBoard;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Click

class VerifyIdeainPipelineStepsViewforEndUsers{
    public void run(def params){
        //Map all values that will be used for verification for that instance
        if(params.Tab){
            if(params.Tab=='Random'){
                Click.run(ID:"//*[@id='ideaboard-filter-button-random']")
            }
            if(params.Tab=='Recent'){
                Click.run(ID:"//*[@id='ideaboard-filter-button-recent']")
            } else {
                Click.run(ID:"//*[@id='ideaboard-filter-button-active' and .='${params.Tab}'] ")
            }
            sleep(3000)
        }
        def verify = [:]
        if(params."Placement Number"){verify.ID = "//*[@class='fractal-pipelineViewIdeas']/*[@class='idea'][${params."Placement Number"}]//SPAN[text()='${params."Idea Name"}']"}	
        else{verify.ID = "//*[@class='fractal-pipelineViewIdeas']/*[@class='idea']//SPAN[text()='${params."Idea Name"}']"}
        
        verify.IDChildren = []
        if(params."Step idea belongs to"){verify.IDChildren << "./../../../../../DIV[contains(text(),'${params."Step idea belongs to"}')]"}
        if(params."Stage idea belongs to" && params."Step idea belongs to"){
            verify.IDChildren << "./../../../../../../..//SPAN[contains(text(),'${params."Stage idea belongs to"}')]"
        } else if(params."Stage idea belongs to" && params."Step idea belongs to"==null){
            verify.IDChildren << "./../../../../..//SPAN[contains(text(),'${params."Stage idea belongs to"}')]"
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify) 
    }
}