package actions.ViewIdea.TeamWorkspace;

import actions.selenium.Exists

class VerifytheRiskiestAssumptioninTeamWorkspaceBanner{
    public void run(def params){
        
        assert Exists.run(ID:"//*[@class='idea-risk-assumption' and contains(.,'${params."Riskiest Assumption"}')]")==1,"Error - Incorrect Riskiest Assumption"
    }
}