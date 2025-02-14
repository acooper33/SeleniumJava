package actions.ProjectRoom;

import actions.selenium.*
import java.nio.file.Paths

class SetRoomSettingsInProjectRoom{
    public void run(def params){
        
        SetText.run(ID:"//*[contains(@class,'f-settings-title')]",Text:params."Room Title", "Type of Clear":"Cut")
        if(params."Click on Generate Link"== true){
            Click.run(ID:"//*[contains(@class,'f-upload-modal-dropzone-browse-text')]")
        } else if(params."Click on Generate Link"== false) {
            def fileName
            String fileN
            if(params."Icon File"){
            	def os = System.getProperty("os.name").toLowerCase()
            	if(os.contains("nix") || os.contains("nux")||os.contains("aix")){
                    fileN = params."Icon File"
                    fileName = Paths.get(".").toAbsolutePath().normalize().toString()+'/TestCaseResourceFiles/'+fileN
               } else {
            		fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."Icon File"}"
                }
                SendKeys.run(ID:"//*[contains(@class,'f-upload-modal-dropzone-input')]",Text:fileName)
            }
        }
        if(params."Preview Image"){
            if(params."Preview Image"=="Image"){
              assert Exists.run(ID:"//*[contains(@class,'f-image-preview') and contains(@style,'/ct/getfile.php?')]")==1, "Error - Image not displayed"
        	} else {
                assert Exists.run(ID:"//*[contains(@class,'f-image-preview') and contains(@style,'${params."Preview Image"}')]")==1, "Error - Colored Tile not displayed as Project Room icon"            
        	}
        }
        if(params."Delete Image"==true){
            Click.run(ID:"//*[contains(@class,'f-reset-file')]/A")
        }
        SetText.run(ID:"//*[contains(@class,'f-settings-description')]",Text:params."Project Description", "Type of Clear":"Cut")
        if(params."Email Notification"==true){
            Click.run(ID:"//*[@class='f-room-settings-toggle-container']/*[contains(@class,'f-checkbox')]/DIV[not(contains(@class,'f-checkbox-checked'))]//INPUT/..","Type of Click":"Move to Element")
        } else if(params."Email Notification"==false) {
                Click.run(ID:"//*[@class='f-room-settings-toggle-container']/*[contains(@class,'f-checkbox')]/DIV[contains(@class,'f-checkbox-checked')]//INPUT/..","Type of Click":"Move to Element")
        }           
        if(params."Action"){
           if(params.Action=='Save'){ 
               Click.run(ID:"//*[contains(@class,'f-room-settings-header-text')]")
           } else {
               Click.run(ID:"//*[contains(@class,'f-room-settings-top-btn')]")
           }
        }
        if(params."Delete Project Room Action"){
            if(Exists.run(ID:"//*[@FOR='f-delete-room-hackathon-checkbox']")==1){
                Click.run(ID:"//*[contains(@class,'f-modal-body')]/../DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper'))]/..//*[contains(text(),'I understand this will affect my')]/..")
            }
            if(params."Delete Project Room Action"=="Delete"){
                Click.run(ID:"//*[@id='f-modal-submit']")
            } else {
                Click.run(ID:"//*[@data-test='modal-footer-cancel']") 
            }
        }
    }
}