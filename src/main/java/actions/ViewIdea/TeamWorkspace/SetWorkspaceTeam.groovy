package actions.ViewIdea.TeamWorkspace;

import actions.selenium.SetText
import actions.selenium.Click

class SetWorkspaceTeam{
    public void run(def params){
     Click.run(ID:"//*[@class='team-top']/A")

        params."User".split(",").eachWithIndex{ name, x ->
            if(params."Add or Remove or Set Leader".split(",")[x]=="Add"){
                SetText.run(ID:"//*[@id='team-members-search']",Text:name,"Type of Clear":"Cut")
                Click.run(ID:"//*[contains(@class,'team-list team-list-left')]//*[text()='${name}']","Type of Click":"Javascript")                
            }
            else if(params."Add or Remove or Set Leader".split(",")[x]=="Remove"){
                Click.run(ID:"//*[@class='member-name' and text()='${name}']/..//I[contains(@class,'fa fa-trash')]")
            }
            else{
                sleep(1000)
                Click.run(ID:"//*[@class='member-name' and text()='${name}']/..//I[contains(@class,'fa fa-key')]")
            }
        }      
        if(params."Action"){
            if(params."Action" == "Update"){Click.run(ID:"//*[@id='team-members-save']")}
            else if(params."Action" == "Cancel"){Click.run(ID:"//*[@id='team-members-cancel']")}
            else {Click.run(ID:"//*[@class='close-buttons' and .='Close']")}
        }
        sleep(5000)
    } 
}