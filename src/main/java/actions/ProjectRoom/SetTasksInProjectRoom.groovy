package actions.ProjectRoom;
import actions.selenium.SendKeyboardAction
import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SetCombobox
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.Keys
import actions.selenium.Browser

class SetTasksInProjectRoom{
    public void run(def params){

        sleep(2000)
        if(params."Add or Edit"=="Edit"){
            Click.run(ID:"//*[@value=\"" + params."Original Task Name" + "\"]")
            SetText.run(Text:params."New Task Name",ID:"//*[@value=\"" + params."Original Task Name" + "\"]","Type of Clear":"Cut")
        } else {
            Click.run(ID:"//*[contains(@class,'f-task-left-actions')]/*[@data-tooltip-content='Add Task']")
            SetText.run(Text:params."New Task Name",ID:"//INPUT[contains(@id,'new-row')]")
        }
        if(params."Click on Esc in Title Field"==null || params."Click on Esc in Title Field"==false){
            Click.run(ID:"//*[contains(@class,'f-tasks-actions-bar')]")
        } else {
            Actions action = new Actions(Browser.Driver)
            action.sendKeys(Keys.ESCAPE).build().perform()
        }
        
        if(params."Assignee"){
            SetCombobox.run(ID:"//*[contains(@class,'f-table-v2-row-draggable')][${params."Row Number"}]/*[@id='table-body-row-${params."Row Number".toInteger() - 1}-cell-2']//INPUT[contains(@class,'f-combobox-input')]", Option:params."Assignee")
        }
        if(params."Status"){
            SetCombobox.run(ID:"//*[contains(@class,'f-table-v2-row-draggable')][${params."Row Number"}]/*[@id='table-body-row-${params."Row Number".toInteger() - 1}-cell-3']//INPUT[contains(@class,'f-combobox-input')]", Option:params."Status")
        }
        if(params."Due Date"){
            if(params."Add or Edit"=="Edit"){
              SetText.run(ID:"//*[contains(@class,'f-table-v2-row-draggable')][${params."Row Number"}]/*[@id='table-body-row-${params."Row Number".toInteger() - 1}-cell-4']//INPUT[contains(@id,'f-rule-trigger-date')]",Text:params."Due Date","Type of Clear":"Cut")  
            } else {
                def dueDate = params."Due Date"
    			def rowNumber = params."Row Number".toInteger()
    			def inputXPath = "//*[contains(@class,'f-table-v2-row-draggable')][${rowNumber}]/*[@id='table-body-row-${rowNumber - 1}-cell-4']//INPUT[contains(@id,'f-rule-trigger-date')]"
    
    			// Clear the input field first (assuming 'Type of Clear': 'Cut' means clear the field)
    			SetText.run(ID:inputXPath, Text:"", "Type of Clear":"Cut")
    
    			// Input the due date character by character
    			for(int i = 0; i < dueDate.size(); i++){
        		SetText.run(ID:inputXPath, Text:dueDate[i], "Type of Clear":"None")
        		sleep(300) // wait briefly to properly trigger any suggestions or validations
                }                
            }
    		
            // Send ENTER key action
    		SendKeyboardAction.run("Button":"ENTER")
        }
/*        if(params."Due Date"){
            SetText.run(ID:"//*[contains(@class,'f-table-v2-row-draggable')][${params."Row Number"}]/*[@id='table-body-row-${params."Row Number".toInteger() - 1}-cell-4']//INPUT[contains(@id,'f-rule-trigger-date')]",Text:params."Due Date","Type of Clear":"Cut")
            SendKeyboardAction.run("Button":"ENTER")
        }*/
        if(params."Mark Complete"==true){
            Click.run(ID:"//*[contains(@class,'f-table-v2-row-draggable')][${params."Row Number"}]/*[@id='table-body-row-${params."Row Number".toInteger() - 1}-cell-1']//I[contains(@class,'far fa-circle-check')]/..","Type of Click":"Move to Element")
        } else if(params."Mark Complete"==false) {
                Click.run(ID:"//*[contains(@class,'f-table-v2-row-draggable')][${params."Row Number"}]/*[@id='table-body-row-${params."Row Number".toInteger() - 1}-cell-1']//I[contains(@class,'fas fa-circle-check')]/..","Type of Click":"Move to Element")
        }
    }
}