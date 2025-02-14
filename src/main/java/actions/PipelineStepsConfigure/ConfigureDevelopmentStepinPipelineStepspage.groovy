package actions.PipelineStepsConfigure;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem
import actions.selenium.*
import actions.selenium.SetFocus
import actions.PipelineStepsConfigure.ConfigureCategoryAssignmentInDevelopmentStep
import actions.PipelineStepsView.SetStepDropdown

class ConfigureDevelopmentStepinPipelineStepspage{
    public void run(def params){
        if(params."Step Name to Configure (optional)"){
            SetStepDropdown.setDropdownOption("Step Name":params."Step Name to Configure (optional)","Step Dropdown Option":"Configure Development")
        }
        Click.run(ID:"//*[@id='advanced-setting-link']")
        sleep(1000)
        SelectItem.run(ID:"//*[@id='assignment-method']","Visible Text":params."Assignment Method")
        ConfigureCategoryAssignmentInDevelopmentStep.run("Development Lead Category":params."Development Lead Category","Development Lead":params."Development Lead","Selected user":params."Selected user","Selected Users Add or Remove":params."Selected Users Add or Remove","Development Team Category":params."Development Team Category","Development Team":params."Development Team","Development Team Add or Remove":params."Development Team Add or Remove")
        if(params."Assignment Method"!="Category Assignment"){
            SelectItem.run(ID:"//*[@id='proposal-lead-dropdown']","Visible Text":params."Development Lead")
            if(params."Development Team"){
                params."Development Team".split(",").eachWithIndex{ name, x ->
                    if(params."Development Team Add or Remove".split(",")[x]=="Add"){
                        SetText.run(ID:"//*[@id='team_typeahead']//*[@id='member_search_input']",Text:name)
                        sleep(2000)
                        Click.run(ID:"//*[@id='atwho-container']//*[@data-value='${name}' or @email='${name}']/DIV/DIV")
                    }
                    else{
                        Click.run(ID:"//*[@id='teamInput']//*[contains(@data-value,'${name}')]/A")                   
                    }
                }
            }
        }
        SetText.run(ID:"//*[@id='days_from_assignment_dynamic']",Text:params."Due Date")
        if(params."Development Field"){
            params."Development Field".split(",").eachWithIndex{ name, x ->
                if(params."Development Field Included or Required".split(",")[x]=="Included"){
                    SetFocus.run(ID:"//*[@id='configure-proposal-field-content']//DIV[text()='${name}']")
                    sleep(1000)
                    Click.run(ID:"//*[@id='configure-proposal-field-content']//DIV[text()='${name}']/..//INPUT[@class='proposal-field-included']")
                    sleep(1000)
                }
                else{
                    SetFocus.run(ID:"//*[@id='configure-proposal-field-content']//DIV[text()='${name}']")
                    sleep(1000)
                    Click.run(ID:"//*[@id='configure-proposal-field-content']//DIV[text()='${name}']/..//INPUT[@class='proposal-field-required']")
                    sleep(500)
                }
            }
        }
        SetCheckBox.run(ID:"//*[@id='private-comments-checkbox']",Check:params."Allow action item assignees to view Private Comments")
        SetCheckBox.run(ID:"//*[@id='idea-editing']",Check:params."Idea Editing")
        SetCheckBox.run(ID:"//*[@id='ai-cancellation']",Check:params."Cancel Open Action Item")
        SetCheckBox.run(ID:"//*[@id='ssc_send_email']",Check:params."Email Alert")
        SetText.run(ID:"//*[@id='ssc_mail_subject']",Text:params."Subject")
        SetText.run(ID:"//*[@id='ssc_email_body']",Text:params."Email")
        if(params."Action"){
            if(params."Action"=="Cancel"){Click.run(ID:"//*[@class='bimodal-secondary' and text()='Cancel']")}
            else if(params."Action"=="Update"){Click.run(ID:"//*[@id='bi-modal-button']/*[text()='Update']")}
            else{Click.run(ID:"//*[@id='bi-modal-button']/*[text()='Activate']")}
            sleep(2000)
        }
    }
}