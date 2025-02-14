package actions.PipelineStepsConfigure;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem
import actions.PipelineStepsView.SetStepDropdown

class ConfigureImplementationStepinPipelineStepspage{
    public void run(def params){
       
         if(params."Step Name to Configure (optional)"){
            SetStepDropdown.setDropdownOption("Step Name":params."Step Name to Configure (optional)","Step Dropdown Option":"Configure Implementation")
        }
        Click.run(ID:"//*[@id='advanced-setting-link']")
        sleep(1000)
        SetText.run(ID:"//*[@id='days_from_assignment_dynamic']",Text:params."Due Date")
        SetCheckBox.run(ID:"//*[@id='idea-editing']",Check:params."Idea Editing")
        SetCheckBox.run(ID:"//*[@id='ai-cancellation']",Check:params."Cancel Open Action Items")
        SetCheckBox.run(ID:"//*[@id='ssc_send_email']",Check:params."Email Alert")
        SelectItem.run(ID:"//*[@id='email-frequency']","Visible Text":params."Send Alerts")
        SetText.run(ID:"//*[@id='ssc_mail_subject']",Text:params."Subject")
        SetText.run(ID:"//*[@id='ssc_email_body']",Text:params."Email")
        if(params."Action"){
            if(params."Action"=="Cancel"){Click.run(ID:"//*[@class='bimodal-secondary' and text()='${params."Action"}']")}
            else{Click.run(ID:"//*[@id='bi-modal-button']/*[text()='${params."Action"}']")}
            sleep(2000)
        }
    }
}
