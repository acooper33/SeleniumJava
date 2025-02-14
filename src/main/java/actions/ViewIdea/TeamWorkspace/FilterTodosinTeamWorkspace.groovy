package actions.ViewIdea.TeamWorkspace;

import actions.selenium.Exists
import actions.selenium.Click

class FilterTodosinTeamWorkspace{
    public void run(def params){

        Click.run(ID:"//*[@id='teamworkspace-tasks-filters-toggle']")
        if(params."Status"){
            params."Status".split(",").each{ value ->
                if(value == "Complete")
                Click.run(ID:"//*[@id='twsfiltersstatuscomplete']")
                else {Click.run(ID:"//*[@id='twsfiltersstatusincomplete']")}
            }
        }
        if(params."Assignee"){
            params."Assignee".split(",").each{ value ->
                Click.run(ID:"//*[@class='filters-header' and text()='Assignee']/..//LABEL[text()='${value}']/INPUT")
                sleep(2000)
            }
        }
        if(params."Due Date"){
            params."Due Date".split(",").each{ value ->
                Click.run(ID:"//*[@class='filters-header' and text()='Due Date']/..//LABEL[text()='${value}']/INPUT")
                sleep(2000)
            }
        }
        if(params."Clear Filters" == true){Click.run(ID:"//*[@class='fractal-droplist filters-droplist']//*[@class='filters-link']")}
        Click.run(ID:"//*[@id='teamworkspace-tasks-filters-toggle']")
    }
}