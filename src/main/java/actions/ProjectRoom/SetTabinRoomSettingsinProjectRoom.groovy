package actions.ProjectRoom;

import actions.selenium.Click

class SetTabinRoomSettingsinProjectRoom{
    public void run(def params){
        
        Click.run(ID:"//*[contains(@class,'f-room-settings-left-nav')]//A/*[text()='${params."Tab"}']")
        
    }
}