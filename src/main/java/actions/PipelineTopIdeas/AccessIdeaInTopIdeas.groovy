package actions.PipelineTopIdeas;

import actions.selenium.Click

class AccessIdeaInTopIdeas{
    public void run(def params){
        
        def set = [:]
        //set.ID= "//*[contains(@class,'f-idea-title')]/SPAN[contains(.,'${params."Idea Name"}')]/../A"        
        set.ID = "//*[contains(@class,'f-idea-title')]/SPAN[contains(.,'${params."Idea Name"}')]"        
        set.IDChildren = []        
        if(params."Idea Code"){set.IDChildren << "./../../..//*[contains(@class,'f-card-link') and .='${params."Idea Code"}']"}
        set."Type of Click"="Javascript"
        Click.run(set)      
    }
}