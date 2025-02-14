package actions.ProjectRoom;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Click

class VerifyRoomPageInFavoritesTabInProjectRoom{
    public void run(def params){
        
        def verify = [:]
        if(params."Placement Number of Page"){
               verify.ID = "//*[contains(@class,'f-rooms-favorites')]//LI[contains(@class,'f-room-item')][${params."Placement Number of Page"}]//*[text()='${params."Room Page"}']/../.."
           } else {
               verify.ID = "//*[contains(@class,'f-rooms-favorites')]//LI[contains(@class,'f-room-item')]//*[text()='${params."Room Page"}']/../.."
           }          
        verify.IDChildren = []
        if(params."Room Icon"){
            if(params."Room Icon"=="Memo"){
                def img
                if(params."Memo Type for Room Icon"=="Google Doc"){img="e1e99555c5a81299e8cc.svg"}
                else if(params."Memo Type for Room Icon"=="OneDrive"){img="ff57833efa91d815a804.svg"}
                else {img="memo-icon2.svg"}
                verify.IDChildren << "./..//IMG[contains(@src,'${img}')]"
            } else if(params."Room Icon"=="Whiteboard"){
                verify.IDChildren << "./..//IMG[contains(@src,'/CORE/IMAGES/whiteboard-icon1.svg')]"
            } else {
            verify.IDChildren << "./..//*[@class='f-nav-item-icon' and text()='${params."Room Icon"}']/../../.."}  
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify) 
        if(params."Access Page"){
            if(params."Access Page"==true){
                Click.run(verify)
            }
        }
    }
}