package actions.PipelineStepsConfigure;

import actions.PipelineStepsView.SetStepDropdown
import actions.common.ConfigureStepModalCommon
import actions.selenium.Click

class ConfigureImplementationinNewModalinPipelineStepspage{
    public void run(def params){
        if(params."Step Name to Configure (optional)"){
            SetStepDropdown.setDropdownOption("Step Name":params."Step Name to Configure (optional)","Step Dropdown Option":"Configure Implementation")
        }
         sleep(1000)
        Click.run(ID:"//*[contains(@class,'f-settings-btn')]")
        ConfigureStepModalCommon.ConfigureAdditionalActionItemItemsStepModal("Allow Assignees to Edit Idea Attributes":params."Idea Editing","Switch to static date":params."Switch to static date","Due Date":params."Due Date")
        ConfigureStepModalCommon.ConfigureNotificationItemsInStepModal("Email Alert":params."Email Alert","Send Alerts":params."Send Alerts","Subject":params."Subject","Email":params."Email")
        ConfigureStepModalCommon.ConfigureResultsAndRulesItemsInStepModal("Cancel Open Action Item":params."Cancel Open Action Items")
 		ConfigureStepModalCommon.ConfigureActionsInStepModal("Action":params."Action")
    }
}
