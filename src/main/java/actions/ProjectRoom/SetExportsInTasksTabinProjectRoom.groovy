package actions.ProjectRoom;

import actions.selenium.Click

class SetExportsInTasksTabinProjectRoom{
    public void run(def params){
        
         Click.run(ID:"//*[contains(@class,'f-task-right-actions')]/BUTTON[@data-tooltip-content='Export']")
        
    }
}