package actions.ProjectRoom;

import actions.selenium.Click

class ProjectRoomCreateProjectRoom{
    public void run(def params){
        Click.run(ID:"//*[contains(@class,'f-rooms-container')]//*[contains(@class,'f-room-add-btn-wrapper')]/BUTTON")
        sleep(1000)
    }
}