package actions.PipelineStepsConfigure;

import actions.PipelineStepsView.SetStepDropdown
import actions.common.AppsCommon
import actions.common.ConfigureStepModalCommon
import actions.selenium.Click

class ConfigureReviewStepinNewModalinPipelineStepspage{
    public void run(def params){
        
        if(params."Step Name to Configure (optional)"){
            SetStepDropdown.setDropdownOption("Step Name":params."Step Name to Configure (optional)","Step Dropdown Option":"Configure Review")
        }
        sleep(1000)
        ConfigureStepModalCommon.ConfigureAssignmentMethodInStepModal("Assignment Method":params."Assignment Method")
        AppsCommon.NewUserPickerAddRemoveInDuplicateNewModal("Field Name":"",User:params."Individual Assignment User","Add or Remove":params."Individual Assignment User Add or Remove")
        Click.run(ID:"//*[contains(@class,'f-settings-btn')]")
        if(params."Category"){
            params."Category".split(",").eachWithIndex{ category, x ->
                def name = params."Category Assignment User".split(",")
                def action = params."Category Assignment User Add or Remove".split(",")
                AppsCommon.NewUserPickerAddRemoveInDuplicateNewModal("Field Name":category,User:name[x],"Add or Remove":action[x])
            }
        }
        ConfigureStepModalCommon.ConfigureAdditionalActionItemItemsStepModal("Each Idea will be assigned to evaluators":params."Each Idea will be assigned to evaluators","Switch to static date":params."Switch to static date","Due Date":params."Due Date")
        ConfigureStepModalCommon.ConfigureNotificationItemsInStepModal("Email Alert":params."Email Alert","Send Alerts":params."Send Alerts","Subject":params."Subject","Email":params."Email")
        ConfigureStepModalCommon.ConfigureResultsAndRulesItemsInStepModal("Cancel Open Action Item":params."Cancel open action items when submission moves out of Step")
        ConfigureStepModalCommon.ConfigureActionsInStepModal("Action":params."Action")
    }
}