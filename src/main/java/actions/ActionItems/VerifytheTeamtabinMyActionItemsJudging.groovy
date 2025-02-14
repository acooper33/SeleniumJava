package actions.ActionItems;
import actions.selenium.Exists

class VerifytheTeamtabinMyActionItemsJudging{
    public void run(def params){

        params."Team Members".split(",").eachWithIndex{ name, x ->
            assert Exists.run(ID:"//*[@class='team_member_info']//*[text()='${name}']") == 1,"Error - Failed to find ${name}"
        }
    }
}
