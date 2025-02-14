package actions.ProjectRoom;

import actions.selenium.*

class SetProjectRoomImagefromSidebar{
    public void run(def params){
        
         if(params."Project Room Icon"){
            if(params."Project Room Icon"=="Image"){
              assert Exists.run(ID:"//*[contains(@class,'f-icon-square') and contains(@style,'/ct/getfile.php?')]")==1, "Error - Image not displayed"
        	} else {
                assert Exists.run(ID:"//*[contains(@class,'f-icon-square') and contains(@style,'${params."Project Room Icon"}')]")==1, "Error - Colored Tile not displayed as Project Room icon"            
        	}
        }
        if(params."Click on Icon"==true){
            Click.run(ID:"//*[contains(@class,'f-icon-square')]","Type of Click":"Move to Element")
        }        
    }
}