package actions.ProjectRoom;


class ReturnElementIDofProjectRoomImage{
    public static run(def params){
        
        def elementLocation
        if(params."Project Image Location"=="Left Bar Top"){
            elementLocation = "//*[contains(@class,'f-icon-square')]"
        } else if(params."Project Image Location"=="Preview Image in Room Settings"){
            elementLocation = "//*[contains(@class,'f-room-settings-icon-container f-update-pr-img')]"
        }
    }
}