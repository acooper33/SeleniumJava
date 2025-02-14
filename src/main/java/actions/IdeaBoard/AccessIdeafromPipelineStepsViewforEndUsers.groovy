package actions.IdeaBoard;

import actions.selenium.Click

class AccessIdeafromPipelineStepsViewforEndUsers{
    public void run(def params){
        def set = [:]
        set.ID= "//*[@class='fractal-pipelineViewIdeas']/*[@class='idea']//SPAN[text()='${params."Idea Name"}']"        
        set.IDChildren = []
        if(params."Stage idea belongs to" && params."Step idea belongs to"){
            set.IDChildren << "./../../../../../../..//SPAN[contains(text(),'${params."Stage idea belongs to"}')]"
        } else if(params."Stage idea belongs to" && params."Step idea belongs to"==null){
            set.IDChildren << "./../../../../..//SPAN[contains(text(),'${params."Stage idea belongs to"}')]"
        }
        if(params."Step idea belongs to"){set.IDChildren << "./../../../../../DIV[contains(text(),'${params."Step idea belongs to"}')]"}
        if(params."Instance"){set."Instance"=params."Instance".toInteger()}
        set."Type of Click"="Javascript"
        Click.run(set)
    }
}