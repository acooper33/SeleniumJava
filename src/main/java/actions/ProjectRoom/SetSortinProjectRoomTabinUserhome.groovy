package actions.ProjectRoom;

import actions.selenium.Click

class SetSortinProjectRoomTabinUserhome{
    public void run(def params){
        
        Click.run(ID:"//*[contains(@class,'fractal-button  f-tab')]//*[text()='${params."Tab"}']")
        
    }
}