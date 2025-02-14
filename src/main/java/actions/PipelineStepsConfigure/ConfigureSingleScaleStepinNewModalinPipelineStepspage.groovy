package actions.PipelineStepsConfigure;

import actions.selenium.SetText
import actions.selenium.Click
import actions.PipelineStepsView.SetStepDropdown
import actions.common.AppsCommon
import actions.common.ConfigureStepModalCommon
import actions.selenium.SetReactTags

class ConfigureSingleScaleStepinNewModalinPipelineStepspage{
    public void run(def params){
    if(params."Step Name to Configure (optional)"){
            SetStepDropdown.setDropdownOption("Step Name":params."Step Name to Configure (optional)","Step Dropdown Option":"Configure Single Scale")
        }
        sleep(1000)
        ConfigureStepModalCommon.ConfigureAssignmentMethodInStepModal("Assignment Method":params."Assignment Method")
        
        if(params."Individual Assignment User") SetReactTags.setMemberTagsWithAddRemoveWithMultipleInputFieldsLabelsSidebySide("Field Name":"",User:params."Individual Assignment User","Add or Remove":params."Individual Assignment User Add or Remove")
       // AppsCommon.NewUserPickerAddRemoveInDuplicateNewModal("Field Name":"",User:params."Individual Assignment User","Add or Remove":params."Individual Assignment User Add or Remove")
        Click.run(ID:"//*[contains(@class,'f-settings-btn')]")
        if(params."Category"){
            params."Category".split(",").eachWithIndex{ category, x ->
                def name = params."Category Assignment User".split(",")
                def action = params."Category Assignment User Add or Remove".split(",")
                SetReactTags.setMemberTagsWithAddRemoveWithMultipleInputFieldsLabelsSidebySide("Field Name":category,User:name[x],"Add or Remove":action[x])
                //AppsCommon.NewUserPickerAddRemoveInDuplicateNewModal("Field Name":category,User:name[x],"Add or Remove":action[x])
            }
            sleep(3000)
        }
        ConfigureStepModalCommon.ConfigureAdditionalActionItemItemsStepModal("Each Idea will be assigned to evaluators":params."Each Idea will be assigned to evaluators","Allow Assignees to Edit Idea Attributes":params."Idea Editing","Switch to static date":params."Switch to static date","Due Date":params."Due Date")
        SetText.run(ID:"//*[@id='f-question-text-area']",Text:params."Question Text","Type Of Clear":"Cut")
        if(params."Rating Scale"){
            Click.run(ID:"//*[@id='f-ratings-drop']/DIV")
            Click.run(ID:"//*[@id='f-ratings-drop']//*[text()='${params."Rating Scale"}']/..")
        }
        ConfigureStepModalCommon.ConfigureNotificationItemsInStepModal("Email Alert":params."Email Alert","Send Alerts":params."Send Alerts","Subject":params."Subject","Email":params."Email")
        ConfigureStepModalCommon.ConfigureResultsAndRulesItemsInStepModal("Cancel Open Action Item":params."Cancel Open Action Item","Evaluation Results":params."Evaluation Results","Display on Submission's Evaluation tab when:":params."Display on Submission's Evaluation tab when:","Results are visible to":params."Results are visible to","Evaluators":params."Evaluators","Submitters":params."Submitters","Send submitters notifications when evaluator results are ready":params."Send submitters notifications when evaluator results are ready","Make evaluators anonymous":params."Make evaluators anonymous","Resend action items when submissions return to Step":params."Resend action items when submissions return to Step")
        if(params."Action"){ConfigureStepModalCommon.ConfigureActionsInStepModal("Action":params."Action")}
        sleep(5000)
    }
}