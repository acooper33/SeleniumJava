package actions.PipelineSetup;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.Exists

class SetActionSelectedScorecardTemplate{
    public void run(def params){
        if(params."Action Dropdown Option"){
            Click.run(ID: "//DIV[contains(@class,'action_menu') and contains(text(),'Actions')]")
            sleep(1000)
        	Click.run(ID:"//*[@id='scorecards_actions_menu']/UL/LI[contains(normalize-space(.),'${params."Action Dropdown Option"}')]")
            sleep(2000)
        }
        if(params."Delete Template Action"=='Delete'){Click.run(ID:"//*[@id='bi-modal-button']")}
        else if(params."Delete Template Action"=='Cancel'){Click.run(ID:"//A[@class='bimodal-secondary' and text()='Cancel']")}
        if(params."Save as New Template Name"){
            SetText.run(ID:"//*[@id='input-box']",Text:params."Save as New Template Name")
            Click.run(ID:"//*[@id='bi-modal-button']")
        }
        sleep(2000)
        if(params."Go Back"==true){
            Click.run(ID:"//*[@id='back-btn']")
            if (Exists.run(ID:"//*[@id='bi-modal-button']")){Click.run(ID:"//*[@id='bi-modal-button']")}
        }
    }
}