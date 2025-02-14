package actions.PipelineDashBoard;

import actions.selenium.*
    
class NavigateToTheTabInSubmissionHover{
    public void run(def params){

        MouseOver.run(ID:"//*[@class='idea-cell']/A[text()='${params."Idea"}']")
        if(params."Tab"=="Milestones" || params."Tab"=="Risky Assumptions" || params."Tab"=="To-dos"){
            Click.run(ID:"//*[@class='idea-cell']/*[contains(@class,'show-tooltip')]//*[.='${params."Tab"}']")
        }
    }
}