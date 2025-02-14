package actions.PipelineStepsConfigure;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.PipelineStepsView.SetStepDropdown

class ConfigureStackRankStepinPipelineStepspage{
    public void run(def params){
        
        if(params."Step Name to Configure (optional)"){
            SetStepDropdown.setDropdownOption("Step Name":params."Step Name to Configure (optional)","Step Dropdown Option":"Configure Stack Rank")
        }
        if(params."Evaluators"){
            params."Evaluators".split(",").eachWithIndex{ name, x ->
                if(params."Evaluators Add or Remove".split(",")[x]=="Add"){
                    SetText.run(ID:"//*[@id='member_search_input']",Text:name)
                    sleep(2000)
                    Click.run(ID:"//*[@id='atwho-container']//*[@class='typeahead-ellipsis-large']//*[contains(text(),'(${name})')]")
                }
                else{
                    Click.run(ID:"//*[@id='member_search_input']//*[contains(text(),'${name}')]/../A")
                }
            }
        }
        SetText.run(ID:"//*[@id='days_from_assignment_dynamic']",Text:params."Due Date")
        SetCheckBox.run(ID:"//*[@id='idea-editing']",Check:params."Idea Editing")
        SetCheckBox.run(ID:"//*[@id='ai-cancellation']",Check:params."Cancel Open Action Item")
        SetCheckBox.run(ID:"//*[@id='ssc_send_email']",Check:params."Email Alert")
        sleep(1000)
        Click.run(ID:"//*[@id='email-edit-icon']","Type of Click":"Javascript")
        sleep(1000)
        SetText.run(ID:"//*[@id='ssc_mail_subject']",Text:params."Subject")
        SetText.run(ID:"//*[@id='ssc_email_body']",Text:params."Email")
        if(params."Action"){
            if(params."Action"=="Cancel"){Click.run(ID:"//*[@class='bimodal-secondary' and text()='Cancel']")}
            else if(params."Action"=="Update"){Click.run(ID:"//*[@id='bi-modal-button']/*[text()='Update']")}
            else{Click.run(ID:"//*[@id='bi-modal-button']/*[text()='Activate']")}
            sleep(3000)
        }
    }
}