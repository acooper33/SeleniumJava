package actions.ViewIdea.TeamWorkspace;

import actions.selenium.Click

class RemoveFilesTeamWorkspace{
    public void run(def params){
        if(params."Verify in Which Tab (optional)"){TeamWorkspaceCommon.NavigateTab(Tab:params."Verify in Which Tab (optional)")}
        def instance = 1
        if (params.Instance){instance = params.Instance.toInteger()}
        if(params."Area"=="Team Workspace"){
            Click.run(ID:"(//*[contains(@class,'fractal-fileblock')]//A[contains(@class,'filename')and text()='${params."Attachment Name"}']/../../DIV[@class='col-1-3']//I[contains(@class,'trash remove')])[${instance}]")
        } else {
            Click.run(ID:"//*[contains(@class,'filename')and text()='${params."Attachment Name"}']/../..//I[contains(@class,'trash')][${instance}]/../..")
        }       
        sleep(3000)
        if(params."Action"){
            if(params."Action"=="Delete"){
              Click.run(ID:"//*[@id='clickToConfirmOkButton']")  
            } else {
              Click.run(ID:"//*[@id='clickToConfirmCancelButton']")  
            }
        }
    }
}