package actions.ViewIdea.TeamWorkspace;

import actions.selenium.Exists

class VerifyErrorMessagesonTeamWorkspace{
    public void run(def params){
        
        if(params."Should Exist" == true){
            sleep(7000)
            assert Exists.run(ID:"//SPAN[contains(.,'${params."Message"}')]")==1, "Error - Element does not exist"
        }else{
            assert Exists.run(ID:"//SPAN[contains(.,'${params."Message"}')]")==0, "Error - Element should not exist, but is displayed" 
        }
        
    }
}