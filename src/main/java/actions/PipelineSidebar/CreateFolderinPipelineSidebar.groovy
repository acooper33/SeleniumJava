package actions.PipelineSidebar;

import actions.selenium.*

class CreateFolderinPipelineSidebar{
    public void run(def params){
        Click.run(ID:"//*[@id='menu-create-folder']")
        SetText.run(ID:"//*[@id='pipeline-create-folder-input']",Text:params."Folder Name")
        Click.run(ID:"//*[@id='create-folder-button']")
        sleep(3000)
    }
}