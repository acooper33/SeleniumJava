package actions.ProjectRoom;

import actions.selenium.Click

class SetActionsDropdowninTasksTab{
    public void run(def params){
        
        Click.run(ID:"//*[@data-test='f-test-dropdown']")
        Click.run(ID:"//*[contains(@class,'f-dropdown-options') and contains(@style,'display: block')]//*[text()='${params."Action Option"}']")
        sleep(3000)
        if(params."Delete Action"){
            if(params."Delete Action"=="Delete"){
                Click.run(ID:"//*[@id='clickToConfirmOkButton']")
            } else {
                Click.run(ID:"//*[@id='clickToConfirmCancelButton']") 
                   }
        }  
    }
}