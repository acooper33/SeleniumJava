package actions.ActionItems;
import actions.selenium.Click
import actions.selenium.Exists

class AccessTeammemberinTeamtab{
    public void run(def params){

        if(Exists.run(ID:"//*[@class='tour-tip']//*[text()='Start Quick Tour']",Timeout:4)>0){
            Click.run(ID:"//*[@class='tour-tip']//*[text()='Start Quick Tour']")
            sleep(500)
            Click.run(ID:"//*[@class='tour-tip']//*[text()='Next']")
            sleep(500)
            if(Exists.run(ID:"//*[contains(text(),'Skip Tour')]",Timeout:2)>0){
                Click.run(ID:"//*[contains(text(),'Skip Tour')]")
            }
            else{
                Click.run(ID:"//*[@class='tour-tip']//*[text()='Next']")
                sleep(500)
                Click.run(ID:"//*[@class='tour-tip']//*[text()='Next']")
                sleep(500)
                Click.run(ID:"//*[@class='tour-tip']//*[text()='Finish']")
            }
        }
        Click.run(ID:"//*[@id='judging_tab_team_member']")
        if(params."Team mate") {
            Click.run(ID:"//*[@class='team_member_info']//*[text()='${params."Team mate"}']")
        }
    }
}