package actions.ProjectRoom;

import actions.selenium.Click

class SetProjectRoomTasksSort{
    public void run(def params){
        
        Click.run(ID:"//*[contains(@class,'f-table-header-sortable')]//*[text()='${params."Column To Sort"}']/..")
        
    }
}