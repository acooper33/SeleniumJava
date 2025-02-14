package actions.ProjectRoom;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyFolderOrRoomPageInProjectRoom{
    public void run(def params){
        
       def verify = [:]
       if(params."Placement Number of Parent Page or Folder"){
           if(params."Placement Number of Child Page or Folder"){
               verify.ID="//*[contains(@class,'f-room-item')][${params."Placement Number of Parent Page or Folder"}]//*[text()='${params."Parent Folder Name"}']/../../../..//*[contains(@class,'f-rooms-folder-dropzone')]/LI[${params."Placement Number of Child Page or Folder"}]//*[text()='${params."Child Page or Folder"}']/../.."
           } else {
               verify.ID="//*[contains(@class,'f-room-item')][${params."Placement Number of Parent Page or Folder"}]//*[text()='${params."Parent Folder Name"}']/../../../..//*[contains(@class,'f-rooms-folder-dropzone')]//*[text()='${params."Child Page or Folder"}']/../.."
           }          
       } else {
           	if(params."Placement Number of Child Page or Folder"){
            	if(params."Parent Folder Name"){
                	verify.ID="//*[contains(@class,'f-rooms-item-wrapper')]//*[text()='${params."Parent Folder Name"}']/../../../..//*[contains(@class,'f-rooms-folder-dropzone')]/LI[${params."Placement Number of Child Page or Folder"}]//*[text()='${params."Child Page or Folder"}']/../.."
            	} else {
                    println("testing1")
                	verify.ID = "//LI[contains(@class,'f-room-item')][${params."Placement Number of Child Page or Folder"}]//*[text()='${params."Child Page or Folder"}']/../.."
            	}
       		}
       }
        verify.IDChildren = []
        if(params."Room Icon"){
            if(params."Room Icon"=="Memo"){
                def img
                if(params."Memo Type for Room Icon"=="Google Doc"){img="e1e99555c5a81299e8cc.svg"}
                else if(params."Memo Type for Room Icon"=="OneDrive"){img="ff57833efa91d815a804.svg"}
                else {img="memo-icon2.svg"}
                verify.IDChildren << "./..//SPAN[contains(@style,'${img}')]"
            } else if(params."Room Icon"=="Whiteboard"){
                verify.IDChildren << "./..//SPAN[contains(@style,'/CORE/IMAGES/whiteboard-icon1.svg')]"
            } else {
            verify.IDChildren << "./..//*[@class='f-nav-item-icon' and text()='${params."Room Icon"}']/../../.."}  
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify) 
        
    }
}