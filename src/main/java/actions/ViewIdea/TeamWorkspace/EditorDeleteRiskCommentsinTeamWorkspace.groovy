package actions.ViewIdea.TeamWorkspace;

import actions.selenium.*

class EditorDeleteRiskCommentsinTeamWorkspace{
    public void run(def params){

        if(Exists.run(ID:"//*[@class='fractal-teamWorkspacePanel-heading']/*[text()='${params."Risk"}']")==0){ 
            Click.run(ID:"//*[contains(@id,'table-body-row') and @value='${params."Risk"}']") 
        }
        if(params."Edit or Delete"=="Edit"){
            Click.run(ID:"//DIV[.='${params."Comment or reply to be modified"}']/../..//*[contains(@data-tooltip-id,'comment-edit')]/I", "Type of Click":"Javascript")   
            SetText.run(ID:"//*[text()='${params."Comment or reply to be modified"}']/..//*[contains(@class,'redactor-styles redactor-in redactor-in')]",Text:params."New comment or reply", "Type of Clear":"Cut")
            if(params."Attachment File"){
                params."Attachment File".split(",").eachWithIndex{ name, x ->
                    def fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${name}"
                    SendKeys.run(ID:"//INPUT[contains(@id,'existing-comment-attachments')]",Text:fileName)
                }
            }
            sleep(2000)   
        } else {
            Click.run(ID:"//DIV[.='${params."Comment or reply to be modified"}']/../..//*[contains(@data-tooltip-id,'comment-delete')]/I", "Type of Click":"Javascript")      
        }
        if(params.Action){
            if(params.Action=="Save"){
                sleep(1000)
                Click.run(ID:"//DIV[contains(@class,'actions-right')]/BUTTON[@id='saveContent']", "Type of Click":"Javascript")
            } else if(params.Action=="EditCancel"){
                sleep(1000)
                Click.run(ID:"//*[@class='comment-cancel']/A", "Type of Click":"Javascript")                
            } else if (params.Action=="Delete"){
                Click.run(ID:"//*[@id='clickToConfirmOkButton']")
            } else {Click.run(ID:"//*[@id='clickToConfirmCancelButton']")}
            sleep(2000)
        }
    }
}