package actions.ViewIdea.TeamWorkspace;

import actions.selenium.Click

class AccessTeamWorkspace{
    public void run(def params){
       Click.run(ID:"//*[@id='idea-team-workspace-wrapper' or contains(@class,'workspace-btn') or contains(@href,'workspace')]") 
       sleep(3000)
    }
}