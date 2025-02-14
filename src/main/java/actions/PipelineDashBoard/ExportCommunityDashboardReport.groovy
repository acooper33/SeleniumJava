package actions.PipelineDashBoard;

import actions.selenium.Click

class ExportCommunityDashboardReport{
    public void run(def params){
        Click.run(ID:"//*[contains(@id,'analytic')]/IMG[@title='Export Innovations']")
        if(params."Action"=="Export"){Click.run(ID:"//*[@id='bi-modal-button']/SPAN[.='Export']")}
        else if(params."Action"=="Export"){Click.run(ID:"//A[@class='bimodal-secondary' and .='Cancel']")}
        
    }
}