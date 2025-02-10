package actions.PipelineStepsView;

import actions.selenium.SetReactModal
import actions.selenium.SetReactTags
import actions.POMHelperAndLocators.FormElements.SetReactDateField
import actions.common.AppsCommon
import actions.selenium.Click
import actions.PipelineStepsView.SetActionMenuinPipelineStepsView

class SetUpdateAssigneeModal{
    public void run(def params){
        
        if(params."Open Modal"==true){
            SetActionMenuinPipelineStepsView.run("Menu Option":"Update Assignees...")
        }
        AppsCommon.NewUserPickerAddRemoveInDuplicateNewModal("Field Name":"",User:params."Additional Assignee","Add or Remove":params."Additional Assignee Add or Remove")
        SetReactDateField.run("Date":params."Due Date")
        if(params."Send email alerts to added users"==true){
            Click.run(ID:"//*[@aria-label='Send email alerts to added users']/div/div")
        }
        if(params."Remove Assignee from incomplete or complete action items"){
            params."Remove Assignee from incomplete or complete action items".split(',').each{user -> 
              Click.run(ID:"//*[text()='${user}']//I")
            }    
        }
        SetReactModal.setModalActionButton("Modal xPath":"", Action:params.Action)        
    }
}