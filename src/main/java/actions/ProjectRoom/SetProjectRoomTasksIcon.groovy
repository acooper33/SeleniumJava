package actions.ProjectRoom;

import actions.selenium.Click

class SetProjectRoomTasksIcon{
    public void run(def params){
        
         
        Click.run(ID:"//*[contains(@class,'f-sort-icon')]//*[text()='${params."Column To Sort"}']/..")
     
    }
}