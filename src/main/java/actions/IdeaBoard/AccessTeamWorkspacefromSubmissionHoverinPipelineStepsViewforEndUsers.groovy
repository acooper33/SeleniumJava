package actions.IdeaBoard;

import actions.selenium.Exists
import actions.selenium.MouseOver
import actions.selenium.Click

class AccessTeamWorkspacefromSubmissionHoverinPipelineStepsViewforEndUsers{
    public void run(def params){
        
        if(Exists.run(ID:"//*[contains(@class,'fractal-pipelineViewRollover')]/*[@class='idea-title' and contains(text(),'${params."Idea"}')]/..[contains(@style,'visible')]") == 0) {
            MouseOver.run(ID:"//*[@class='fractal-pipelineViewIdeas']/*[@class='idea']//SPAN[text()='${params."Idea"}']")      
        }
        Click.run(ID:"//*[contains(@class,'fractal-pipelineViewRollover')]/*[@class='idea-title' and contains(text(),'${params."Idea"}')]/..//*[@class='idea-workspace']")  
    }
}
