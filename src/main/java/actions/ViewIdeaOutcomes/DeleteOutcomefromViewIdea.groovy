package actions.ViewIdeaOutcomes;

import actions.selenium.Click
import actions.common.ViewIdeaCommon

class DeleteOutcomefromViewIdea{
    public void run(def params){
        
        ViewIdeaCommon.NavigateTab("Tab":"Outcomes")
        
        if (params."Outcome Name"){
            Click.run(ID:"//*[@class='outcome-name']/*[contains(text(),'${params."Outcome Name"}')]/../../../*[contains(@class,'grid-action-button')]", "Type of Click":"Javascript")
            Click.run(ID:"//*[@class='outcome-name']/*[contains(text(),'${params."Outcome Name"}')]/../../../../../*[contains(@class,'grid-action-dropdown')]/*[contains(@class,'outcome-delete')]")
            if (params."Action" == "Delete Outcome"){Click.run(ID:"//*[@id='bi-modal-button']//*[contains(text(),'Delete Outcome')]")}
            if(params."Action"=="Cancel"){Click.run(ID:"//*[@id='button-bimodal-secondary-label']//*[contains(text(),'Cancel')]")}
        }
    }
}