package actions.PipelineStepsConfigure;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SelectItem
import actions.PipelineStepsView.SetStepDropdown

class ConfigureProjectStepinPipelineStepspage{
    public void run(def params){
        
        if(params."Step Name to Configure (optional)"){
            SetStepDropdown.setDropdownOption("Step Name":params."Step Name to Configure (optional)","Step Dropdown Option":"Configure Project")
        }
        if(params."Project Owner"){
            params."Project Owner".split(",").eachWithIndex{ name, x ->
                if(params."Project Owner Add or Remove".split(",")[x]=="Add"){
                    SetText.run(ID:"//*[@id='member_search_input']",Text:name)
                    sleep(2000)
                    Click.run(ID:"//*[@id='atwho-container']//*[@class='typeahead-ellipsis-large']//*[contains(text(),'(${name})')]")
                }
                else{
                    Click.run(ID:"//*[@id='member_search_input']//*[contains(text(),'${name}')]/../A")
                }
            }
        }
        if(params."Project Team"){
            params."Project Team".split(",").eachWithIndex{ name, x ->
                if(params."Project Team Add or Remove".split(",")[x]=="Add"){
                    SetText.run(ID:"(//*[@id='member_search_input'])[2]",Text:name)
                    sleep(2000)
                    Click.run(ID:"//*[@id='atwho-container']//*[@class='typeahead-ellipsis-large']//*[contains(text(),'(${name})')]")
                }
                else{
                    Click.run(ID:"(//*[@id='member_search_input'])[2]//*[contains(text(),'${name}')]/../A")
                }
            }
        }
        SelectItem.run(ID:"//*[@id='new_project_privacy']","Visible Text":params."Privacy")
        
        if(params."Action"){
            if(params."Action"=="Cancel"){Click.run(ID:"//*[@class='bimodal-secondary' and text()='Cancel']")}
            else if(params."Action"=="Create Project"){Click.run(ID:"//*[@id='bi-modal-button']/*[text()='Create Project']")}
            else if(params."Action"=="Update"){Click.run(ID:"//*[@id='bi-modal-button']/*[text()='Update']")}
            else{Click.run(ID:"//*[@id='bi-modal-button']/*[text()='Activate']")}
            sleep(2000)
        }
    }
}