package actions.ViewIdea.TeamWorkspace;

import actions.selenium.Click


class ExportBusinessModelCanvasTeamWorkspace{
    public void run(def params){
        Click.run(ID:"//*[@class='questions-export-btn']/SPAN[text()='Export Canvas']")
        if(params."Export Action"=="Export"){Click.run(ID:"//BUTTON[@id='clickToConfirmOkButton']")}
        else if(params."Export Action"=="Cancel"){Click.run(ID:"//BUTTON[@id='clickToConfirmCancelButton']")}
    }
}