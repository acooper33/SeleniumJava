package actions.PipelineStepsView;

import actions.selenium.SendKeyboardAction
import actions.selenium.SetCheckBox
import actions.selenium.Click
import actions.selenium.SetText

class SetScoutAppAIModal{
    public void run(def params){
        
       SetText.run(ID:"//*[contains(@class,'fractal-input')]//*[contains(@class,'f-import-with-ai-input')]",Text:params."Type","Type of Clear":"Cut")
        if(params."Search Type"){
            if(params."Search Type"=="Using Button"){
            	Click.run(ID:"//*[contains(@class,'f-import-with-ai-body')]//BUTTON[not(contains(@class,'f-import-with-ai-input-btn btn-disabled'))]")
        		} else if(params."Search Type"=="Using Enter") {
            		SendKeyboardAction.run("Button":"ENTER")
            }
        }
        if(params."All Checkbox"){
            if(params."All Checkbox" == "TRUE"){Click.run(ID:"//*[@class='f-checkbox']/*[not(contains(@class,'f-checkbox-checked'))]//*[@id='f-import-with-ai-select-all']/..","Type of Click":"Move to Element")}
            if(params."All Checkbox" == "FALSE"){Click.run(ID:"//*[@class='f-checkbox']/*[contains(@class,'f-checkbox-checked')]//*[@id='f-import-with-ai-select-all']/..","Type of Click":"Move to Element")}
        }
               
        if(params."Company to be Selected"){
                params."Company to be Selected".split(",").eachWithIndex{name, x ->
                    if(params."Company to be Selected Option Check of Uncheck".split(",")[x]=="Check"){Click.run(ID:"//*[@class='f-import-with-ai-results-item']//*[contains(text(),'${name}')]/..//*[@class='f-checkbox']/*[not(contains(@class,'f-checkbox-checked'))]//*[@id='f-import-with-ai-results-checkbox']/..","Type of Click":"Move to Element")}
                    else{Click.run(ID:"//*[@class='f-import-with-ai-results-item']//*[contains(text(),'${name}')]/..//*[@class='f-checkbox']/*[contains(@class,'f-checkbox-checked')]//*[@id='f-import-with-ai-results-checkbox']/..","Type of Click":"Move to Element")}
                	
                }
            }
        if(params."Action"){
            if(params."Action"=="Import"){
                Click.run(ID:"//*[@id='f-modal-submit']")
            } else if(params."Action"=="Cancel"){
                Click.run(ID:"//*[@data-test='modal-footer-cancel']")
            } else {
                Click.run(ID:"//*[@data-tooltip-id='modal-close']")
            }
        }
    }
}