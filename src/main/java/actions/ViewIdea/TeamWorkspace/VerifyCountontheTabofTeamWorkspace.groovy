package actions.ViewIdea.TeamWorkspace;

import actions.selenium.Exists

class VerifyCountontheTabofTeamWorkspace{
    public void run(def params){
      
        assert Exists.run(ID:"//*[@class='fractal-teamWorkspaceMenu']/*[contains(.,'${params."Tab Name"}')][contains(.,'${params."Count"}')]") == 1,"Error - Incorrect ${params."Count"} for tab ${params."Tab Name"}"
    }
}