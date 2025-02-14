package actions.SetupScheduler;

import actions.selenium.SetCheckBox
import actions.selenium.Click
import actions.selenium.SelectItem
import actions.common.SetupCommon
import actions.selenium.Exists
import screens.SiteSetup.SchedulerLocators
import screens.common.ModalButtonLocators
import screens.ReactFormDifferentFieldLocators

class SetDisableScheduler{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Scheduling")
        
        SchedulerLocators.run(params)
        ModalButtonLocators.run(params)
        sleep(2000)
        if(Exists.run(ID:"//DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper'))]/..//SPAN[text()='Enable Scheduler']/..")){
            Click.run(ID:"//DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper'))]/..//SPAN[text()='Enable Scheduler']/..")
        }
        Click.run("ID Type":"By", By:SchedulerLocators.disableScheduler)
        if(params."Status"){
            Click.run(ID:"//*[text()='Status']/..//*[@data-test='f-test-dropdown']")
            Click.run(ID:"//*[contains(@class,'f-dropdown-options') and contains(@style,'display: block')]//*[text()='${params."Status"}']")
        }
        
        // Handle multiple-choice fields (Enable Submission, Voting, Commenting)
        if(params."Enable Submission"){
            if (params."Enable Submission"==true) {
                Click.run(ID:"//DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper'))]/..//SPAN[text()='Enable Submission']/..")
            } else {
                Click.run(ID:"//DIV[contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper')]/..//SPAN[text()='Enable Submission']/..")
            }
        }
        if(params."Enable Voting"){
            if (params."Enable Voting"==true) {
                Click.run(ID:"//DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper'))]/..//SPAN[text()='Enable Voting']/..")
            } else {
                Click.run(ID:"//DIV[contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper')]/..//SPAN[text()='Enable Voting']/..")
            }
        }
        if(params."Enable Commenting"){
            if (params."Enable Commenting"==true) {
                Click.run(ID:"//DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper'))]/..//SPAN[text()='Enable Commenting']/..")
            } else {
                Click.run(ID:"//DIV[contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper')]/..//SPAN[text()='Enable Commenting']/..")
            }
        }
        if(params.Action=="Disable Schedule"){
            Click.run("ID Type":"By", By:ModalButtonLocators.saveButton)
        } else {
            Click.run("ID Type":"By", By:ModalButtonLocators.cancelButton)
        }
        sleep(2000) 
    }
}
