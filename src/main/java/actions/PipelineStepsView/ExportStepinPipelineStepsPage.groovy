package actions.PipelineStepsView;

import actions.selenium.Click
import actions.selenium.SetCheckBox

class ExportStepinPipelineStepsPage{
    public void run(def params){
        if(params."Step to Export"){
        	Click.run(ID:"//SPAN[@class='step_header_name' and text()='${params."Step to Export"}']/../DIV[contains(@class,'img-dropdown')]")
        	sleep(2000)
            Click.run(ID:"//*[@class='step_dropdown' and not(contains(@style,'none'))]/*[@id='dropdown-sub-export-step']")
        }  
        if(params."Action Items" != null){
        	SetCheckBox.run(ID:"//*[@id='action_item_export']",Check:params."Action Items")
        }
        if(params."Submissions" != null){
        	SetCheckBox.run(ID:"//*[@id='idea_export']",Check:params."Submissions")
        }
        
        if(params."Action"){
            Click.run(ID:"//*[@class='bimodal-footer']//*[text()='${params."Action"}']")  
        }      
    }
}