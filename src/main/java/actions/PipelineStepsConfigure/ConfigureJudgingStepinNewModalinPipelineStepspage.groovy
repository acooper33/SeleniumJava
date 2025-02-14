package actions.PipelineStepsConfigure;

import actions.selenium.Click
import actions.PipelineStepsView.SetStepDropdown
import actions.common.AppsCommon
import actions.common.ConfigureStepModalCommon

class ConfigureJudgingStepinNewModalinPipelineStepspage{
    public void run(def params){
     
        if(params."Step Name to Configure (optional)"){
            SetStepDropdown.setDropdownOption("Step Name":params."Step Name to Configure (optional)","Step Dropdown Option":"Configure Judging")
        }
        sleep(1000)
        AppsCommon.NewUserPickerAddRemoveInDuplicateNewModal("Field Name":"",User:params."Judges","Add or Remove":params."Judges Add or Remove")
        Click.run(ID:"//*[contains(@class,'f-settings-btn')]")

        ConfigureStepModalCommon.ConfigureAdditionalActionItemItemsStepModal("Each Idea will be assigned to evaluators":params."Each Idea will be assigned to evaluators","Allow Assignees to Edit Idea Attributes":params."Allow Assignees to Edit Idea Attributes","Switch to static date":params."Switch to static date","Due Date":params."Due Date")

        if(params."Scorecard Template"){
            Click.run(ID:"//*[@id='f-scorecardTemp-drop']")
            Click.run(ID:"//*[@id='f-scorecardTemp-drop']//*[text()='${params."Scorecard Template"}']/..")
        }
        ConfigureStepModalCommon.ConfigureNotificationItemsInStepModal("Email Alert":params."Email Alert","Send Alerts":params."Send Alerts","Subject":params."Subject","Email":params."Email")
        ConfigureStepModalCommon.ConfigureResultsAndRulesItemsInStepModal("Cancel Open Action Item":params."Cancel Open Action Item")
 		ConfigureStepModalCommon.ConfigureActionsInStepModal("Action":params."Action")
       
    }
}