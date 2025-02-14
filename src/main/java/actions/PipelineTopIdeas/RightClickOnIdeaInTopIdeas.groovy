package actions.PipelineTopIdeas;

import actions.selenium.RightClick

class RightClickOnIdeaInTopIdeas{
    public void run(def params){
        if(params."Idea Title"){
            RightClick.run(ID:"//*[contains(@class,'f-idea')]//*[contains(@class,'f-idea-title')]/SPAN[contains(.,'${params."Idea Title"}')]")
        }
    }
}