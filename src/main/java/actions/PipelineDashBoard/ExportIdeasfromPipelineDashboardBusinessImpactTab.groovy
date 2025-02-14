package actions.PipelineDashBoard;

import actions.selenium.Click

class ExportIdeasfromPipelineDashboardBusinessImpactTab{
    public void run(def params){
        Click.run(ID:"//*[@id='export-button']")
        sleep(1000)
        if(params."Action"=="Export"){Click.run(ID:"//*[@id='clickToConfirmOkButton']")}
        else{click.run(ID:"//*[@id='exportCancel']")}
    }
}