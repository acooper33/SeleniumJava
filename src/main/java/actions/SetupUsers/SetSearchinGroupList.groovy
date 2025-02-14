package actions.SetupUsers;

import org.openqa.selenium.By
import actions.selenium.SetText
import screens.SystemSetup.GroupCreationLocators 
import actions.selenium.Click

class SetSearchinGroupList{
    public void run(def params){
        
        GroupCreationLocators.run(params)
        SetText.run(Text:params."Group Name","ID Type":"By", By:GroupCreationLocators.searchField,"Type of Clear":"Cut")
        if(params."Clear Search"){
            if(params."Clear Search"==true){
                Click.run("ID Type":"By", By:GroupCreationLocators.closeIconOnSearchField)
            }
        }        
    }
}