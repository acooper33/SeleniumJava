package actions.PipelineStepsConfigure;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem
import actions.selenium.SetFocus
import actions.selenium.ExplicitWait
import actions.PipelineStepsView.SetStepDropdown
import java.lang.*

class ConfigureSingleScaleStepinPipelineStepspage{
    public void run(def params){
        if(params."Step Name to Configure (optional)"){
            SetStepDropdown.setDropdownOption("Step Name":params."Step Name to Configure (optional)","Step Dropdown Option":"Configure Single Scale")
        }
        Click.run(ID:"//*[@id='advanced-setting-link']")
        sleep(1000)
        SelectItem.run(ID:"//*[@id='assignment-method']","Visible Text":params."Assignment Method")
        if(params."Individual Assignment User"){
            params."Individual Assignment User".split(",").eachWithIndex{ name, x ->
                if(params."Individual Assignment User Add or Remove".split(",")[x]=="Add"){
                    SetText.run(ID:"//*[@id='member_search_input']",Text:name)
                    sleep(2000)
                    Click.run(ID:"//*[@id='atwho-container']//*[@data-value='${name}' or @email='${name}']/DIV/DIV")
                   //Click.run(ID:"//*[@id='atwho-container']//*[@class='typeahead-ellipsis-large']//*[contains(text(),'(${name})')]", "Type of Click":"Javascript")
                }
                else{
                    Click.run(ID:"//*[@id='member_search_input']//*[contains(text(),'${name}')]/../A")
                }
            }
        }
        if(params."Category"){
            params."Category".split(",").eachWithIndex{ category, x ->
                def user = params."Category Assignment User".split(",")
                if(params."Category Assignment User Add or Remove".split(",")[x]=="Add"){
                    SetFocus.run(ID:"//*[@class='category_item']//*[contains(text(),'${category}')]/../..//*[@id='member_search_input']")
                    SetText.run(ID:"//*[@class='category_item']//*[contains(text(),'${category}')]/../..//*[@id='member_search_input']",Text:user[x])
                    sleep(2000)
                    Click.run(ID:"//DIV[@class='atwho-view' and contains(@style,'block')]//*[@data-value='${user[x]}']/DIV/DIV")
                }
                else{
                    Click.run(ID:"//*[@id='member_search_input']//*[contains(text(),'${user[x]}')]/../A")
                }
            }
        }
        if(params."Each Idea will be assigned to evaluators"){
            SetCheckBox.run(ID:"//INPUT[@id='load-balancer-checkbox']", Check:Boolean.parseBoolean("true"))
            SelectItem.run(ID:"//*[@id='num_idea']","Visible Text":params."Each Idea will be assigned to evaluators")
        }
        SetCheckBox.run(ID:"//*[@id='idea-editing']",Check:params."Idea Editing")
        SetCheckBox.run(ID:"//*[@id='ai-cancellation']",Check:params."Cancel Open Action Item")
        SetCheckBox.run(ID:"//*[@id='ssc_send_email']",Check:params."Email Alert")
        SelectItem.run(ID:"//*[@id='email-frequency']","Visible Text":params."Send Alerts")
        SetText.run(ID:"//*[@id='ssc_mail_subject']",Text:params."Subject")
        SetText.run(ID:"//*[@id='ssc_email_body']",Text:params."Email")
        SetText.run(ID:"//*[@id='single-scale-advance-question']",Text:params."Question Text")
        SelectItem.run(ID:"//*[@id='rating_range']","Visible Text":params."Rating Scale")
        //Anna: evaluations tab settings
        if(params."Evaluation Results"){
            SetCheckBox.run(ID:"//*[@id='feedback_tab_checkbox']", Check:params."Evaluation Results") //checks/unchecks Eval Results Checkbox
            SelectItem.run(ID:"//*[@id='display_results']", "Visible Text":params."Display on Submission's Evaluation tab when:")
            if(params."Results are visible to"){
                if(params."Results are visible to"=="Administrators and select roles"){
                    Click.run(ID:"//*[@id='admins_and_select_roles']")
                    SetCheckBox.run(ID:"//*[@id='eval_result_visibility_evaluator']", Check:params."Evaluators")
                    SetCheckBox.run(ID:"//*[@id='eval_result_visibility_submitter']", Check:params."Submitters")
                }
                else if(params."Results are visible to"=="Administrators only"){
                    ExplicitWait.run(ID:"//*[@id='admins_only']")
                    Click.run(ID:"//*[@id='admins_only']","Type of Click":"Javascript")}
                else if(params."Results are visible to"=="All roles"){Click.run(ID:"//*[@id='all_roles']")}
            }
            if(params."Options"){
                if(params."Options"=="Send submitters notifications when evaluator results are ready"){SetCheckBox.run(ID:"//*[@id='feedback_notification']",Check:params."Options")}
                if(params."Options"=="Make evaluators anonymous"){SetCheckBox.run(ID:"//*[@id='feedback_anonymous']",Check:params."Options")}
            }
        }
        if(params."Action"){
            if(params."Action"=="Cancel"){Click.run(ID:"//*[@class='bimodal-secondary' and text()='Cancel']")}
            else if(params."Action"=="Update"){Click.run(ID:"//*[@id='bi-modal-button']/*[text()='Update']")}
            else{Click.run(ID:"//*[@id='bi-modal-button']/*[text()='Activate']")}
            sleep(2000)
        }
    }
}