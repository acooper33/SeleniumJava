package actions.ProjectRoom;

import actions.selenium.*

class SetRoomPageintheProjectRoom{
    public void run(def params){
        
        if(params."Folder Name in which Room Page is added"){
            if(params."Parent Folder Name if the Folder to add Page is Child Folder"){
                SetFocus.run(ID:"//*[contains(@class,'f-rooms-item-wrapper')]//*[text()='${params."Parent Folder Name if the Folder to add Page is Child Folder"}']/../../../..//*[contains(@class,'f-rooms-folder-dropzone')]/LI[${params."Placement Number Of Folder Name"}]//*[text()='${params."Folder Name in which Room Page is added"}']/../..")
            	Click.run(ID:"//*[contains(@class,'f-btn-xs f-btn-subtle')][2]")
            } else {
                SetFocus.run(ID:"//LI[contains(@class,'f-room-item')][${params."Placement Number Of Folder Name"}]//*[text()='${params."Folder Name in which Room Page is added"}']/../..")
            	Click.run(ID:"//*[contains(@class,'f-btn-xs f-btn-subtle')][2]")
            }
        } else {
            Click.run(ID:"//*[contains(@class,'f-rooms-pages-heading')]//*[contains(@class,'f-btn-xs f-btn-subtle')]")
        }
        if(params."Type of Room Page"){
            Click.run(ID:"//*[contains(@class,'f-rooms-add-menu')]//*[text()='${params."Type of Room Page"}']/..")
            sleep(3000)
        }        
    }
}