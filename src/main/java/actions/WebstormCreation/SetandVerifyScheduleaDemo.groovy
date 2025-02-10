package actions.WebstormCreation;

import actions.selenium.Exists
import actions.selenium.Click

class SetandVerifyScheduleaDemo{
    public void run(def params){
        
        Click.run(ID:"//button[normalize-space()='${params."Action"}']")
        if(params."Verify the Modal Displayed"){
            if(params."Verify the Modal Displayed"==true){
                 assert Exists.run(ID:"//form[contains(@id,'hsForm_')]")==1, "Modal not displayed"
            }
        }
    }
}