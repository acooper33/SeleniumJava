package actions.ProjectRoom;

import screens.Userhome.ProjectRoom.ProjectRoomUserhomeLocators
import org.openqa.selenium.By
import actions.selenium.*

class SetProjectRoomSearchinUserhome{
    public void run(def params){
    
        ProjectRoomUserhomeLocators.run(params)
        if(params."Click on Clear"==true){
            Click.run("ID Type":"By", By:ProjectRoomUserhomeLocators.clearOnSearchField)
            sleep(3000)
        }

        if(params."Search Text"){
            SetText.run(Text:params."Search Text","ID Type":"By",By:ProjectRoomUserhomeLocators.searchField) 
            sleep(3000)
        }
    }
}