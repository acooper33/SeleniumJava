package actions.SetupIdeas;

import actions.common.SetupCommon
import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.ExecuteJavascript
import java.io.*

class HideRemoveandShowFieldsfromWebstormSetupIdeasForSubmissionFormTab{
    public void run(def params){
		boolean success = false
        def y = 200
        if(Exists.run(ID:"//*[@id='saveFormButton']")==0) { 
            SetupCommon.NavigateTab(Tab:"Ideas",Section:"Submission Form")
            Click.run(ID:"//*[@id='edit-idea']")} 
        while(!success){
            try {
                ExecuteJavascript.run(Code:"window.scrollTo(0, ${y});")
                Click.run(ID:"//DIV[contains(@class,'f-question-row f-question-header') and contains(.,'${params."Field Name"}')]//DIV[@class='f-question-action' and text()='${params."Action"}']")
                success = true
            }catch (Exception e){
                println("Exception caught: ${e}")
                //scroll down
                y+=300
            }
        }        
        if (params."Action" == "Remove"){
            if(params."Delete/Cancel Remove" == "Delete") {Click.run(ID:"//BUTTON[@id='clickToConfirmOkButton']")}
            else {Click.run(ID:"//BUTTON[@id='clickToConfirmCancelButton']")}
        }
        if(params."Save Form"){Click.run(ID:"//*[@id='saveFormButton']","Type of Click":"Javascript")}
    }   
}