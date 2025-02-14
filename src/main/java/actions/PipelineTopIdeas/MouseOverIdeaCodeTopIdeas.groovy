package actions.PipelineTopIdeas;

import actions.selenium.MouseOver

class MouseOverIdeaCodeTopIdeas{
    public void run(def params){
        if(params."Idea Title"){
            MouseOver.run(ID:"//*[contains(@class,'f-idea')]//*[contains(@class,'f-idea-title')]/SPAN[contains(.,'${params."Idea Title"}')]/../A")
            println("Over title")
        }else if(params."Idea Code"){
            MouseOver.run(ID:"//*[contains(@class,'f-idea')]//*[contains(@class,'f-idea-title')]/A[.='${params."Idea Code"}']")
            println("Over code")
        }
    }
}