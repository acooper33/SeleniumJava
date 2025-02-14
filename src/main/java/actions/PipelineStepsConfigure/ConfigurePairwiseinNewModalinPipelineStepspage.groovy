package actions.PipelineStepsConfigure;

import actions.selenium.SetCheckBox
import actions.PipelineStepsView.SetStepDropdown
import actions.common.AppsCommon
import actions.common.ConfigureStepModalCommon

class ConfigurePairwiseinNewModalinPipelineStepspage{
    public void run(def params){
        
    if(params."Step Name to Configure (optional)"){
            SetStepDropdown.setDropdownOption("Step Name":params."Step Name to Configure (optional)","Step Dropdown Option":"Configure Pairwise")
        }
        sleep(1000)
        AppsCommon.NewUserPickerAddRemoveInDuplicateNewModal("Field Name":"",User:params."Evaluators","Add or Remove":params."Evaluators Add or Remove")
     
        ConfigureStepModalCommon.ConfigureAdditionalActionItemItemsStepModal("Allow Assignees to Edit Idea Attributes":params."Idea Editing","Switch to static date":params."Switch to static date","Due Date":params."Due Date")
        SetCheckBox.run(ID:"//*[@id='f-auto-ratings']/..",Check:params."Automatic Ratings")
        ConfigureStepModalCommon.ConfigureNotificationItemsInStepModal("Email Alert":params."Email Alert","Send Alerts":params."Send Alerts","Subject":params."Subject","Email":params."Email")
        ConfigureStepModalCommon.ConfigureResultsAndRulesItemsInStepModal("Cancel Open Action Item":params."Cancel Open Action Item")
 		ConfigureStepModalCommon.ConfigureActionsInStepModal("Action":params."Action")
    }
}